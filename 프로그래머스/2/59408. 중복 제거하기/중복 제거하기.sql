-- 코드를 입력하세요
select 
    count(distinct name) count
from 
    ANIMAL_INS
where 
   NAME is not null; 