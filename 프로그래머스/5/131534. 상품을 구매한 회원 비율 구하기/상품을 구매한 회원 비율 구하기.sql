-- 코드를 입력하세요
SELECT
   year(o.sales_date) "YEAR",
   month(o.sales_date) "MONTH",
   count(distinct u.user_id) "PURCHASED_USERS",
   round(count(distinct u.user_id) / 
        (select count(*) from user_info where Year(joined) = 2021), 1
    ) "PURCHASED_RATIO"
from user_info u
    join online_sale o on u.user_id = o.user_id
where
    year(u.joined) = 2021
group by
    year(o.sales_date), month(o.sales_date)
order by 
    year(o.sales_date), month(o.sales_date);