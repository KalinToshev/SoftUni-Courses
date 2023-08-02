import { useEffect, useState } from "react";
import ShoppingCartItem from "./ShoppingCartItem";
import ShoppingCartForm from "./ShoppingCartForm";
import { buyProdut, getAllProducts } from "../services/service";

export default function ShoppingCart() {
  const [products, setProducts] = useState([]);
  const totalPrice = products
    .filter((product) => product.isBought)
    .reduce((acc, product) => acc + product.price, 0);

  useEffect(() => {
    getAllProducts().then((products) => setProducts(Object.values(products)));
  }, []);

  return (
    <section className="shopping-cart__container">
      <ShoppingCartForm />
      <section className="shopping-cart__items-list">
        {products.map((product) => (
          <ShoppingCartItem
            key={product.name}
            item={product}
            handleBuyItem={(productId) => {buyProdut(productId)}}
            handleRemoveItem={(productId) => {deleteProduct(productId)}}
          />
        ))}
      </section>
      <div className="shopping-cart__total-price">
        <h1>Total Price: {totalPrice}$</h1>
      </div>
    </section>
  );
}
