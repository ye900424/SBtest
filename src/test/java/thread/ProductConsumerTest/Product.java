package thread.ProductConsumerTest;

public class Product {
        private int id;

        public Product(int id) {
            this.id = id;
        }

        public String toString() {// 重写toString方法
            return "Product:" + this.id;
        }
    }