# Write your MySQL query statement below
(Select u.name as results from MovieRating mr
left join Users u on mr.user_id = u.user_id
group by mr.user_id, u.name
order by Count(*) desc, u.name asc limit 1)
union all
(Select m.title as results from MovieRating mr
left join Movies m on mr.movie_id = m.movie_id
where Year(created_at)=2020 and Month(created_at)=2
group by mr.movie_id, m.title
order by AVG(mr.rating) Desc, m.title asc limit 1)