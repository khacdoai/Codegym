use quan_ly_sinh_vien;
select *
from student
where StudentName like 'h%';

select *
from class
where month(StartData) = 12;

select * 
from subject
where Credit >= 3 and Credit <= 5;

update student
set ClassId = 2
where StudentName = 'Hung';

select S.StudentName, Sub.Subname, M.Mark 
from student S join mark M on S.StudentID = M.studentId join `subject` Sub on M.subId = Sub.SubId
order by M.mark desc , S.StudentName asc;