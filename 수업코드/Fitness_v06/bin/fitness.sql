DROP TABLE fitness;
DROP SEQUENCE fitness_seq; 

CREATE TABLE fitness 
(
    seqno NUMBER NOT NULL,
    userid VARCHAR2(20) PRIMARY KEY, 
    username VARCHAR2(20) NOT NULL, 
    height NUMBER(5,2) DEFAULT 0, 
    weight NUMBER(5,2) DEFAULT 0

);

CREATE SEQUENCE fitness_seq; 







INSERT INTO fitness
(seqno,userid,username,height,weight)
VALUSE 
(fitness_seq.NEXTVAL, 'hong', '홍길동', '175.5', '69.7');




