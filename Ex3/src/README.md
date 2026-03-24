Kiểu biến MathUtils được trỏ tới phương thức AdvancedMath

In ra dòng (A), dòng (B)
Dòng (A) in ra 20, bởi vì lúc gọi m.sum thì hàm phương thức đó được gọi và gọi ở class AdvancedMath

Dòng (B) lỗi bởi vì, đó là kiểu biến MathUtils chứ không phải AdvancedMath, vì thế nó chỉ gọi các phương thức được override ở AdvancedMath hoặc phương thức ở MathUtils
=> Và ở đây thì không gọi được phương thức ở AdvancedMath


cách sửa tạo 1 biến kiểu AdvancedMath m = new AdvancedMath();