package bg.softuni.hiberspring.service.impl;

import bg.softuni.hiberspring.domain.dtos.ProductImportDTO;
import bg.softuni.hiberspring.domain.dtos.ProductsWrapperDTO;
import bg.softuni.hiberspring.domain.entities.Branch;
import bg.softuni.hiberspring.domain.entities.Product;
import bg.softuni.hiberspring.repository.BranchRepository;
import bg.softuni.hiberspring.repository.ProductRepository;
import bg.softuni.hiberspring.service.ProductService;
import bg.softuni.hiberspring.util.FileUtil;
import bg.softuni.hiberspring.util.ValidationUtil;
import bg.softuni.hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static bg.softuni.hiberspring.common.Constants.INCORRECT_DATA_MESSAGE;
import static bg.softuni.hiberspring.common.Constants.SUCCESSFUL_IMPORT_MESSAGE;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final FileUtil fileUtil;

    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final BranchRepository branchRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, FileUtil fileUtil, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return fileUtil.readFile("products.xml");
    }

    @Override
    public String importProducts() throws JAXBException, IOException {
        StringBuilder stringBuilder = new StringBuilder();

        ProductsWrapperDTO productsWrapperDTO = xmlParser.parseXml(ProductsWrapperDTO.class, "src/main/resources/files/products.xml");

        List<ProductImportDTO> products = productsWrapperDTO.getProducts();

        for (ProductImportDTO product : products) {
            boolean isValid = validationUtil.isValid(product);

            if (isValid) {
                Optional<Branch> byName = branchRepository.findByName(product.getBranch());

                if (byName.isEmpty()) continue;

                Product productToSave = modelMapper.map(product, Product.class);

                byName.ifPresent(productToSave::setBranch);

                productRepository.saveAndFlush(productToSave);

                stringBuilder.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Product", product.getName())).append(System.lineSeparator());

            } else stringBuilder.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
