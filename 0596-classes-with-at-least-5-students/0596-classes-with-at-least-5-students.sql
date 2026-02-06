# Write your MySQL query statement below
Select c1.class from (Select Count(student) totalStudents, class from Courses group by class) c1 where c1.totalStudents>=5