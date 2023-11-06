select *
from subject
where Credit = (select max(Credit) from `subject`);

select su.SubName, su.credit, su.status, m.mark 
from subject su join mark m on su.SubId = m.subId
where m.mark = (select max(mark) from mark);

select s.studentId, s.StudentName , avg(m.mark) as diem 
from student s  left join mark m on s.StudentID = m.studentId
group by s.studentId, s.StudentName
order by diem desc;


