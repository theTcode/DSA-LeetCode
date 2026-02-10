# Write your MySQL query statement below
Select st.student_id, st.student_name, sj.subject_name, Count(ex.subject_name) as attended_exams
from Students st
Cross join Subjects sj 
left join Examinations ex on st.student_id = ex.student_id and sj.subject_name = ex.subject_name
group by st.student_id, st.student_name, sj.subject_name
order by st.student_id, sj.subject_name