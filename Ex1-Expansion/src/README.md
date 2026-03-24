Nâng cao (Bắt buộc):
Sửa lớp Person: Xóa constructor mặc định đi, thay bằng constructor có tham số: public Person(String name) { ... }.
Quan sát: Lúc này lớp Employee và Manager có báo lỗi không? Tại sao?
Sửa lỗi: Hãy dùng từ khóa super(...) để sửa lỗi biên dịch cho lớp con.

Giải:
+ Nếu thay bằng constructor có tham số: public Person(String name){}
=> Lớp Employee và Manager có báo lỗi bởi vì, lúc này lớp con là Emp và Ma sẽ tự động gọi hàm super(), với không tham số được kế thừa.
+ Nhưng bị mâu thuẫn, bởi tham số được tạo bởi hàm khởi tạo Person trên.

+ Vì thế nên trước khi thay thế bằng constructor trên thì constructor không được khởi tạo bằng tham số vẫn đúng bởi hàm super không kế thừa tham số trên

Cách sửa:
+ Thêm hàm super(...)   //thêm tham số được kế thừa ở lớp cha, vào hàm super()
+ Thêm tham số vào hàm