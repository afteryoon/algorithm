-- 코드를 입력하세요
SELECT 
fp.product_id, fp.product_name, fp.product_cd, fp.category, max(fp.price)
From FOOD_PRODUCT fp
where fp.price = (
select max(price)
from food_product
);
