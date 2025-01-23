-- 코드를 작성해주세요
select
     e.ID, count(d.id) as CHILD_COUNT
from 
    ECOLI_DATA e left join ECOLI_DATA d
    on e.id = d.PARENT_ID
group by
    e.ID
order by
    e.id;