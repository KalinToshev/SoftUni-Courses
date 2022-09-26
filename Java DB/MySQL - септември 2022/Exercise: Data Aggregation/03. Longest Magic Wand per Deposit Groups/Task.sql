SELECT
`deposit_group`,
MAX(`magic_wand_size`) AS 'Longest Magic Wand'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `Longest Magic Wand`, `deposit_group`;
