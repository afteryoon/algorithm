-- 코드를 입력하세요
SELECT
    i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
from 
    animal_ins i join animal_outs o 
    on i.animal_id = o.animal_id
where i.SEX_UPON_INTAKE like 'Intact%'
        and (o.SEX_UPON_OUTCOME like  'Neutered%' or o.SEX_UPON_OUTCOME like  'Spayed%'   )
order by i.ANIMAL_ID;