-- 코드를 작성해주세요
select 
    fi.ID, fni.FISH_NAME, fi.LENGTH
from
    FISH_INFO fi join FISH_NAME_INFO fni
    on fi.FISH_TYPE = fni.FISH_TYPE
where
     fi.LENGTH = (
        select
            max(LENGTH)
        from
            FISH_INFO fi2
        where
            fi2.FISH_TYPE = fi.FISH_TYPE
    )
order by
    fi.ID;
