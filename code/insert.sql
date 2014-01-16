-- creating and dropping tables ---------------------------
-----------------------------------------------------------
TRUNCATE TABLE ratings;
CREATE TABLE ratings(
  `rowid` int(11) NOT NULL AUTO_INCREMENT,
  `univid` int(11) DEFAULT NULL,
  `profDept` varchar(50) DEFAULT NULL,
  `profRatings` int(11) DEFAULT NULL,
  `profAvg` float DEFAULT NULL,
  `profEasy` float DEFAULT NULL,
  `profId` int(11) DEFAULT NULL,
  PRIMARY KEY (`rowid`)
);

TRUNCATE TABLE universities;
CREATE TABLE universities (
  `univid` int(11) NOT NULL AUTO_INCREMENT,
  `univname` varchar(200) DEFAULT NULL,
  `univstate` varchar(50) DEFAULT NULL,
  `lastupdated` datetime DEFAULT NULL,
  PRIMARY KEY (`univid`)
);

TRUNCATE TABLE professors;
CREATE TABLE `professors` (
  `rowid` int(11) NOT NULL AUTO_INCREMENT,
  `profId` int(11) NOT NULL,
  `univId` int(11) NOT NULL,
  `profDept` varchar(45) NOT NULL,
  `Class` varchar(45) DEFAULT NULL,
  `Easiness` float DEFAULT NULL,
  `Helpfulness` float DEFAULT NULL,
  `Clarity` float DEFAULT NULL,
  `RaterInterest` float DEFAULT NULL,
  PRIMARY KEY (`rowid`)
);





-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `insertUpdateRatings`(IN v_univid int, v_profDept varchar(50), v_profRatings int, v_profAvg float, v_profEasy float, v_profId int)
BEGIN

DECLARE t int;

select rowid into t from test.ratings where profId = v_profId;
select t;

if (t is null) then
    INSERT INTO ratings(univid,profDept,profRatings,profAvg,profEasy,profID) VALUES (v_univid,v_profDept,v_profRatings,v_profAvg,v_profEasy,v_profId);

else
begin

UPDATE ratings SET profDept=v_profDept, profRatings=v_profRatings, profAvg=v_profAvg, profEasy=v_profEasy where rowId = t;
select * from ratings;
        
end;

END IF;

UPDATE universities SET lastUpdated=now() WHERE univid=v_univid;

END


-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `insertUpdateProfessors`(IN v_profid int, v_univid int, v_profDept varchar(50), v_Class varchar(50), v_Easiness float, v_Helpfulness float, v_Clarity float, v_RaterInterest float)
BEGIN

INSERT INTO professors(profid,univid,profDept,Class,Easiness,Helpfulness,Clarity,RaterInterest) VALUES (v_profid,v_univid,v_profDept,v_Class,v_Easiness,v_Helpfulness,v_Clarity,v_RaterInterest);

END


-------------------Testing Stored Procedures----------------------------------------
truncate ratings;
call insertupdateratings(800,'a',60,'2.4','2.3',500);
select * from ratings;
call insertupdateratings(800,'a',60,2.4,2.3,500);
select * from ratings;

SELECT count(*) FROM ratings where profRatings>=100;
SELECT * FROM ratings where profRatings>=100 group by profDept;

select distinct profDept from ratings;

SELECT profDept, ROUND(AVG(profAvg) ,2) AS "Prof Average",  ROUND(AVG(profEasy) ,2) AS "Prof Easiness"  FROM ratings where profRatings>=100 group by profDept order by 2 DESC;
SELECT profDept, ROUND(AVG(profAvg) ,2) AS "Prof Average",  ROUND(AVG(profEasy) ,2) AS "Prof Easiness"  FROM ratings where profRatings>=100 group by profDept order by 3 DESC;


SELECT * FROM universities;
truncate universities;
truncate ratings;
select univid from universities where lastUpdated is null limit 100;

SELECT * FROM universities where univid = 825 or univid=1072 or univid=1073 or univid=1222;
SELECT * FROM professors where univid = 825 or univid=1072 or univid=1073 or univid=1222;
SELECT * FROM ratings where univid = 825 or univid=1072 or univid=1073 or univid=1222;

SELECT * FROM professors;
call InsertUpdateProfessors(81132,825,'Psychology','Psych321',3,5,5,4); 
truncate professors;
call insertUpdateProfessors(123,1234,'math','math 21a',3,4,5,2);

select count(*) from professors where univid=825;
select count(*) from professors where univid=1072;
select count(*) from professors where univid=1073;
select count(*) from professors where univid=1222;

