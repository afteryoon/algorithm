-- 코드를 입력하세요
SELECT
    f.FLAVOR
from first_half f
    join july j on f.FLAVOR = j.FLAVOR
group by f.FLAVOR
order by sum(f.TOTAL_ORDER + j.TOTAL_ORDER) desc
Limit 3;