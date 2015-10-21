http://www.avajava.com/tutorials/lessons/how-do-i-display-a-prepared-statement-with-bind-variables-using-mysql.html



http://stackoverflow.com/questions/2382532/how-can-i-get-the-sql-of-a-preparedstatement

Using prepared statements, there is no "SQL query" :

You have a statement, containing placeholders
it is sent to the DB server
and prepared there
which means the SQL statement is "analysed", parsed, some data-structure representing it is prepared in memory
And, then, you have bound variables
which are sent to the server
and the prepared statement is executed -- working on those data
But there is no re-construction of an actual real SQL query -- neither on the JAVA side, nor on the database side.

So, there is no way to get the prepared statement's SQL -- as there is no such SQL.


For debugging purpose, the solutions are either to :

Ouput the code of the statement, with the placeholders ; and the list of data
Or to "build" some SQL query "by hand".