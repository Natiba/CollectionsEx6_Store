
package Entity;

import java.util.Objects;

public class Store {
    
    private String product;
    private Integer price;

    public Store() {
    }

    public Store(String product, Integer price) {
        this.product = product;
        this.price = price;
      
    }

    public String getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.product);
        hash = 37 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Store other = (Store) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Store {" + "product: " + product + ", price: " + price + '}';
    }
    
}

//Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos productos que  
//venderemos y el precio que tendrán. Además, se necesita que la aplicación cuente con las funciones básicas.
//Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio, eliminar un producto y 
//mostrar los productos que tenemos con su precio (Utilizar Hashmap). 
//El HashMap tendrá de llave el nombre del producto y de valor el precio. 
//Realizar un menú para lograr todas las acciones previamente mencionadas.