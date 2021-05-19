# IoTbay Deployment Instructions

## Note:
These instructions have only been tested in NetBeans IDE version `12.3`, any prior versions of this IDE may have different steps which are not specified here.  
You can read these instructions from [github](https://github.com/ormux/iotbay/tree/01-online-user-access-management) for a nicely formatted view of the text.
## Database Setup
1. On the NetBeans IDE go to `Services > Java DB > Create Database` and make an Apache Derby database with the following credentials:
   - dbname: `iotdb`
   - user: `isduser`
   - pass: `admin`
2. The file `sql/output.txt` contains a series of SQL statements, copy the contents of this file to your clipboard.
3. Right click on `iotdb` and click `Connect`, then right click on the JDBC connection url `jdbc:derby://localhost:1527/iotdb [isduser on ISDUSER]`
4. Click `Execute Command` then paste the SQL statements and __highlight__ everything with `CTRL+A`, right click on the text while it is highlighted and select `Run Selection`
5. Every single table should be created and errors should not appear in the NetBeans console, verify that the tables exist by checking `jdbc:derby://localhost:1527/iotdb [isduser on ISDUSER] > ISDUSER > Tables`

## Website Setup
1. On the NetBeans IDE right-click on `Files>Import Project>From Zip...` then navigate to the location of this project, named `iotbay.zip` and import the contents to your NetBeans projects.
2. You can view this instructions in a nicely formatted
