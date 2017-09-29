UPDATE payments
SET tax_rate = tax_rate/1.03;
SELECT tax_rate FROM payments;