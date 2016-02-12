


select count(*) from Germplasm_Pedigree_build

SELECT p.parent_germplasm_id, p.child_germplasm_id 
FROM Germplasm g JOIN Pedigree p ON g.germplasm_id = p.child_germplasm_id WHERE g.is_obsolete = 'F' ORDER BY 1,2 


select * from Germplasm_Pedigree_wrk;

--DELETE
    Germplasm_Pedigree_build
WHERE
    species_variant_id IS NULL
    AND germplasm_id IN(
        SELECT
            w1.germplasm_id
        FROM
            Germplasm_Pedigree_build w1
        WHERE
            species_variant_id IS NULL
            AND EXISTS(
                SELECT
                    germplasm_id
                FROM
                    Germplasm_Pedigree_build w2
                WHERE
                    species_variant_id IS NOT NULL
                    AND germplasm_id = w1.germplasm_id
                    AND taxon_id = w1.taxon_id
            )
        GROUP BY
            w1.germplasm_id,
            w1.taxon_id
    )
    AND taxon_id IN(
        SELECT
            w3.taxon_id
        FROM
            Germplasm_Pedigree_build w3
        WHERE
            species_variant_id IS NULL
            AND EXISTS(
                SELECT
                    germplasm_id
                FROM
                    Germplasm_Pedigree_build w4
                WHERE
                    species_variant_id IS NOT NULL
                    AND germplasm_id = w3.germplasm_id
                    AND taxon_id = w3.taxon_id
            )
        GROUP BY
            w3.germplasm_id,
            w3.taxon_id
    )

============

SELECT TAIR_OBJECT_ID, NOTEPAD_ID, NOTEPAD_COMMENT, STATUS, PERSON_ID, DATE_ENTERED
FROM TAIRPROD.NOTEPAD order by date_entered desc;


SELECT LocusComment.tairObjectId, LocusComment.notepadId, LocusComment.communityId, LocusComment.name, LocusComment.commentText, 
LocusComment.dateEntered FROM LocusComment WHERE LocusComment.tairObjectId = 2207165 ORDER BY dateEntered desc


select * from person where community_id = 1501492689 -- name = 'e1'

update person set REGISTERING_FOR_ABRC = 'F' where community_id = 1501492689 ;

commit;

SELECT PERSON_ID, COMMUNITY_ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, SUFFIX, 
RESEARCH_INTEREST, BIRTHDATE, IS_USER_FOCUS, IS_EXTERNAL_CURATOR, 
IS_TAIR_CURATOR, PRIMARY_JOB_TITLE, LAST_NAME_UC, FIRST_NAME_UC, 
SEND_MAIL, EXPIRATIONDATE, AUTORENEW, INSTITUTIONNAME, SUBSCRIBING_PI, REGISTERING_FOR_ABRC
FROM TAIRPROD.PERSON order by community_id desc;

select * from community where community_id = 1501492689

 SELECT country_id, name, stock_center, phytosanitary_required, express_shipping_multiplier, date_last_modified 
 FROM Country WHERE lower(name) LIKE lower(?)

 
 select * from community where community_id = 1501492659
 
 
 ==============
 SELECT * FROM PENDINGPAYMENT WHERE order_number = 116087 ORDER BY created DESC; 
 -----------|-------------|---------------------------------|----------------|--------------------|
1000078080 |116087       |4d847ea85f552791a286fe7c30aeb9fc |ACCEPT_DECISION |2015-11-16 15:12:53 |
1000077829 |116087       |05b5279c9724275943f47744b3345ce5 |CANCELLED       |2015-10-01 13:01:28 |
1000077786 |116087       |787dbf071197e692f42079e1e2f16758 |CANCELLED       |2015-09-29 12:22:24 |
1000077728 |116087       |af986e059240d0a2e2fca0083a165d33 |CANCELLED       |2015-09-25 12:44:02 |
1000077677 |116087       |2f4e3b160f404a3fb7d51d75465562d6 |CANCELLED       |2015-09-22 20:22:10 |
1000077676 |116087       |596cc6d81df4caef29d550a041200b0c |CANCELLED       |2015-09-22 19:15:43 |


 SELECT * FROM PENDINGPAYMENT WHERE order_number = 113057 ORDER BY created DESC;
 ID         |ORDER_NUMBER |TOKEN                            |STATUS          |CREATED             |
-----------|-------------|---------------------------------|----------------|--------------------|
1000074463 |113057       |27692c013d4ccb67b2144cbf3cd7f6fd |CANCELLED       |2015-03-23 16:56:34 |

 -----------
 email entry req_reference_number=113057 corresponds to ORDERNUMBER in PAYMENTINFO tbl
 email entry transaction_id=4425066568915000001513 corresponds to REQUESTID in PAYMENTINFO table
 email entry request_token=Ahj/7wSR38RFDtdmWQfSICmrFm0ZNWLdk0T94p9u3wBT94p9u3zSBt3BSMhk0kyro9It7KBOR38RFDtdmWQfSAAAlRf7 corresponds to PENDING_PAYMENT_TOKEN  
 
 
 SELECT * FROM PAYMENTINFO ORDER BY paymentinfo.ORDER_DATE DESC;
ORDER_DATE          |DECISION |DECISION_PUBLICSIGNATURE |ORDERAMOUNT |ORDERAMOUNT_PUBLICSIGNATURE |ORDERCURRENCY |ORDERCURRENCY_PUBLICSIGNATURE |ORDERNUMBER |ORDERNUMBER_PUBLICSIGNATURE |ORDERPAGE_REQUESTTOKEN |ORDERPAGE_TRANSACTIONTYPE |REQUESTID              |PENDING_PAYMENT_TOKEN                                                                        |
2015-11-18 12:47:05 |ACCEPT   |                         |60.0        |                            |usd           |                              |113057      |                            |                       |authorization             |4425066568915000001513 |Ahj/7wSR38RFDtdmWQfSICmrFm0ZNWLdk0T94p9u3wBT94p9u3zSBt3BSMhk0kyro9It7KBOR38RFDtdmWQfSAAAlRf7 |
2015-11-18 10:39:09 |ACCEPT   |                         |60.0        |                            |usd           |                              |113057      |                            |                       |authorization             |4425066568915000001513 |Ahj/7wSR38RFDtdmWQfSICmrFm0ZNWLdk0T94p9u3wBT94p9u3zSBt3BSMhk0kyro9It7KBOR38RFDtdmWQfSAAAlRf7 |
2015-11-16 15:13:36 |ACCEPT   |                         |30.0        |                            |usd           |                              |116087      |                            |                       |authorization             |4477156155325000001518 |4d847ea85f552791a286fe7c30aeb9fc                                                             |
 
SELECT * FROM PENDINGPAYMENT ORDER BY created DESC;
 
SELECT * FROM PAYMENTINFO where ORDERNUMBER like '%116087%' or ORDERNUMBER like '113057'; -- ORDER BY paymentinfo.ORDER_DATE DESC;

SELECT * FROM PENDINGPAYMENT WHERE TOKEN='4d847ea85f552791a286fe7c30aeb9fc'

SELECT * FROM PAYMENTINFO where ORDERNUMBER ='116087' 



SELECT * FROM PENDINGPAYMENT WHERE order_number = 116087 ORDER BY created DESC

SELECT * FROM PAYMENTINFO where ORDERNUMBER = '116087'

select ORDER_DATE,DECISION,ORDERNUMBER,REQUESTID,PENDING_PAYMENT_TOKEN FROM PAYMENTINFO where ORDERNUMBER like '116087'

 
select user_name, p.IS_TAIR_CURATOR
from Community c JOIN Person p ON c.community_id = p.community_id
where EMAIL = 'andrey@arabidopsis.org'; 

select * from community where email='andrey@arabidopsis.org'
COMMUNITY_ID |COMMUNITY_TYPE |EMAIL                  |LAST_UPDATED        |USER_NAME  |PASSWORD   |IS_OBSOLETE |PASSWORD_HINT |ACCESSION |STATUS |EMAIL_FAILURES |DATE_ENTERED        |
-------------|---------------|-----------------------|--------------------|-----------|-----------|------------|--------------|----------|-------|---------------|--------------------|
1501494758   |person         |andrey@arabidopsis.org |2015-10-01 13:16:18 |cyber      |cyber      |F           |              |          |active |0              |2015-10-01 13:14:46 |
1501495035   |person         |andrey@arabidopsis.org |2015-11-19 23:25:21 |andreynew2 |0319       |F           |              |          |active |0              |2015-11-19 22:14:57 |
1501495022   |person         |andrey@arabidopsis.org |2015-11-17 22:23:46 |andreynew  |0319       |F           |              |          |active |0              |2015-11-17 22:22:59 |

select SEND_MAIL from Person where community_id in (1501495035) -- email='andrey@arabidopsis.org'

select SEND_MAIL from Person where community_id in (select community_id from community where user_name = 'andreynew2')

update Person.s set SEND_MAIL  = 'T' where community_id in (1501495035)

select user_name, p.IS_TAIR_CURATOR
from Community c JOIN Person p ON c.community_id = p.community_id
where EMAIL = 'curator@arabidopsis.org'; 


Eva+Huala+Laboratory

SELECT COMMUNITY_ID, ORGANIZATION_ID, CONTACT_PERSON_ID, NAME, ORGANIZATION_TYPE, DESCRIPTION, ABRC_FEES_WAIVED, NASC_FEE_PAID, COMMERCIAL, SEED_STOCK_CENTER, NAME_UC, ABBREV_NAME
FROM ORGANIZATION where COMMUNITY_ID = 1501482776;

update ORGANIZATION set ABRC_FEES_WAIVED = 'T' where COMMUNITY_ID = 1501482776;

commit




