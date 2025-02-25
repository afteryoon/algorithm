-- 코드를 입력하세요
SELECT
    HOUR(DATETIME) "HOUR",
    count(*) "COUNT"
from
    ANIMAL_OUTS
WHERE
    HOUR(DATETIME) >= 9 AND
    HOUR(DATETIME) < 20
group by
    HOUR(DATETIME)
order by
    HOUR(DATETIME);