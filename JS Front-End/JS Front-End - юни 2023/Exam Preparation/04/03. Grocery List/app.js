const baseURL = "http://localhost:3030/jsonstore/grocery/";

document.querySelector("#load-product").addEventListener("click", loadProducts);

document.querySelector("#add-product").addEventListener("click", addProduct);

async function loadProducts(e) {
  e.preventDefault();

  const response = await fetch(baseURL);
  const data = await response.json();

  const products = Object.values(data);

  const tBodyElement = document.querySelector("#tbody");

  tBodyElement.innerHTML = "";

  products.forEach((product) => {
    const trElement = document.createElement("tr");
    trElement.setAttribute("data-id", product._id);

    const tdNameElement = document.createElement("td");
    tdNameElement.textContent = product.product;
    tdNameElement.classList.add("name");

    const tdCountElement = document.createElement("td");
    tdCountElement.textContent = product.count;
    tdCountElement.classList.add("count-product");

    const tdPriceElement = document.createElement("td");
    tdPriceElement.textContent = product.price;
    tdPriceElement.classList.add("product-price");

    const tdButtonsElement = document.createElement("td");
    tdButtonsElement.classList.add("btn");

    const updateButtonElement = document.createElement("button");
    updateButtonElement.textContent = "Update";
    updateButtonElement.classList.add("update");
    updateButtonElement.addEventListener("click", updateProduct);

    const deleteButtonElement = document.createElement("button");
    deleteButtonElement.textContent = "Delete";
    deleteButtonElement.classList.add("delete");
    deleteButtonElement.addEventListener("click", deleteProduct);

    tdButtonsElement.appendChild(updateButtonElement);
    tdButtonsElement.appendChild(deleteButtonElement);

    trElement.appendChild(tdNameElement);
    trElement.appendChild(tdCountElement);
    trElement.appendChild(tdPriceElement);
    trElement.appendChild(tdButtonsElement);

    tBodyElement.appendChild(trElement);
  });
}

async function addProduct(e) {
  e.preventDefault();

  const product = document.querySelector("#product").value;
  const count = document.querySelector("#count").value;
  const price = document.querySelector("#price").value;

  if (product == "" || count == "" || price == "") {
    alert("All fields are required!");
    return;
  }

  const response = await fetch(baseURL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ product, count, price }),
  });

  document.querySelector("#product").value = "";
  document.querySelector("#count").value = "";
  document.querySelector("#price").value = "";

  loadProducts(e);
}

async function deleteProduct(e) {
  e.preventDefault();

  const id = e.target.parentElement.parentElement.getAttribute("data-id");

  const response = await fetch(baseURL + id, {
    method: "DELETE",
  });

  loadProducts(e);
}

async function updateProduct(e) {
  e.preventDefault();

  const id = e.target.parentElement.parentElement.getAttribute("data-id");

  const productName =
    e.target.parentElement.parentElement.querySelector(".name").textContent;

  const productCount =
    e.target.parentElement.parentElement.querySelector(
      ".count-product"
    ).textContent;

  const productPrice =
    e.target.parentElement.parentElement.querySelector(
      ".product-price"
    ).textContent;

    //Fill the form with the data from the product
    document.querySelector("#product").value = productName;
    document.querySelector("#count").value = productCount;
    document.querySelector("#price").value = productPrice;

    //Disable add product button and enable update product button
    document.querySelector("#add-product").disabled = true;
    document.querySelector("#update-product").disabled = false;

    //Add event listener to the update button
    document.querySelector("#update-product").addEventListener("click", (e) => {
        e.preventDefault();

        const updateProduct = {
            product: document.querySelector("#product").value,
            count: document.querySelector("#count").value,
            price: document.querySelector("#price").value,
            id,
        }
    
        fetch(baseURL + id, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(updateProduct),
        });

        //Enable add product button and disable update product button
        document.querySelector("#add-product").disabled = false;
        document.querySelector("#update-product").disabled = true;

        //Clear the form
        document.querySelector("#product").value = "";
        document.querySelector("#count").value = "";
        document.querySelector("#price").value = "";

        loadProducts(e);
    });
}
