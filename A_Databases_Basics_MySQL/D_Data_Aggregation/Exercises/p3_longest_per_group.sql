SELECT deposit_group, MAX(magic_wand_size) AS 'longest_magic_wand'
FROM wizzard_deposits AS d
GROUP BY d.deposit_group
ORDER BY longest_magic_wand,d.deposit_group;