export async function getAllProducts() {
  const response = await fetch("http://localhost:3030/jsonstore/products/");
  return response.json();
}

export async function createProduct(product) {
  const response = await fetch("http://localhost:3030/jsonstore/products/", {
    method: "POST",
    body: JSON.stringify(product),
  });

  return response.json();
}

export async function buyProdut(productId) {
  const response = await fetch(
    `http://localhost:3030/jsonstore/products/${productId}`,
    {
      method: "PATCH",
      body: JSON.stringify({ isBought: true }),
    }
  );

  return response.json();
}

export async function deleteProduct(productId) {
    const response = await fetch(
        `http://localhost:3030/jsonstore/products/${productId}`,
        {
        method: "DELETE",
        }
    );
    
    return response.json();
}