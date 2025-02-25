-- 코드를 작성해주세요
select
    fi.ID ID,
    fni.FISH_NAME FISH_NAME,
    fi.LENGTH LENGTH
from
    FISH_INFO fi join FISH_NAME_INFO fni
    on fi.FISH_TYPE = fni.FISH_TYPE
where
    fi.LENGTH = (
        select
            max(LENGTH)
        from
            FISH_INFO fi2
        where fi.FISH_TYPE = fi2.FISH_TYPE
    ) and
    fi.LENGTH > 10
order by
    id;
