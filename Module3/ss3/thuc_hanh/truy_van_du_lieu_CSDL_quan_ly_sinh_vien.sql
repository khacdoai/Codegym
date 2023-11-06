use quan_ly_sinh_vien;
select * 
from  student
where `status` = true;
select * 
from `subject` 
where Credit < 10;

select S.StudentID, S.StudentName, C.ClassName
from student S join class C on S.ClassId = C.ClassID
where C.ClassName = 'A1';

select S.StudentID, S.StudentName, Sub.Subname, M.Mark
from student S join mark M on S.StudentID = M.studentId join `Subject` Sub on M.subId = Sub.SubId 
where sub.subname = 'CF';