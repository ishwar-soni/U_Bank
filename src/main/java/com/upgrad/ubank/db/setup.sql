CREATE TABLE UBANK_ACCOUNTS (
    accountNo NUMBER PRIMARY KEY,
    password VARCHAR2(100),
    balance NUMBER
);
/
CREATE TABLE UBANK_TRANSACTIONS (
    accountNo NUMBER,
    date_ VARCHAR2(100),
    action VARCHAR2(100),
    amount NUMBER
);