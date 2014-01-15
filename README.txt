This is my Undergraduate Research Project for ECS 199.

Project Title:
FINDING DEPENDENCIES BETWEEN RATINGS AND MAJORS

Objective:
The objective of this project is to compare and contrast humanities and computer science professor ratings to figure out which majors get the higher ratings using a T-Test and a university chosen at random. 
Hypothesis is that ratings for humanities and social science professors are higher because the curriculum is easier than CS, students get low grades in their first CS class as opposed to humanities and social sciences, and thus, students tend to go for those majors opposed to Computer Science, Mathematics, and Engineering.

Motivation:
On average, college students declare their major(s) and minor(s) by the end of their sophomore year. On average, Computer Science, Mathematics, Engineering, and other physical sciences tend to scare students away from these majors and career fields due to their difficult curriculum and learning curve compared to humanities and social science majors and careers. More than 15 million student-generated comments & ratings of over 1.8 million professors at over 8,000 schools have been made at RateMyProfessors.com. Comments and ratings are only two factors in the students' decisions to choosing courses and professors every quarter and semester, and they play a larger role now more than ever because of the high popularity of this website's content. There is currently no scientific evidence to suggest that students are moving away from the physical sciences to the humanities and social sciences. Over time, scientists, professors, educators, and leaders around the country and the world may propose or implement a new way of teaching students for these tougher majors in order to attract and retain more students who, otherwise, would not continue with these majors due to their level of difficulty.

Goals:
In doing this research project, we hope to achieve the following goals: To prove the hypothesis that humanities and social science professors get higher ratings and approval opposed to computer science professors. To create database with data. To find patterns based on major and ratings. To provide a filtered visualization of the data with professors, departments, and ratings. To create a detailed final report explaining the results, providing future direction, and, hopefully, changing the way professors teach Science and Engineering courses.

Project Plan:
We will begin the project by researching how to scrape the web using Java scraping libraries and Java HTML Parsers, setting up Eclipse IDE for web application, scraping, and connecting to the database, setting up WAMP: Windows, Apache HTTPD Web Server, MySQL Database Server, and PHP Engine, as well as phpMyAdmin Database Manager, for database connectivity and data filtering, and designing a relational database schema for our results where the primary keys will be professor, subject, and rating. 

We will study possible methods for storing the information, and visualizing it appropriately via a web application. We will need to do several statistical tests, such as a T-Test, to determine if two sets of data are significantly different from each other and to prove the hypothesis. 

We will set it up so that it scrapes 100 hits/day on RateMyProfessors.com for a random university and is being added to the database for analysis and reporting in the filtered results. 

Secondary keys could be by course and by quarter/semester, but main study is on the subject and the rating. 

We will study which, if any, of the methods we research can be reasonably implemented and find the most efficient one for our application domain. This will involve examining the theory behind these methods and considering the costs, in terms of speed, reliability, and ease of use, associated with each method. We can optimize website results using different primary key, foreign key, constraint combinations. Maybe easiness is more important than equality. Set a filter to have minimum total ratings. 

Our initial assumption is that humanities and social science professors get higher ratings and approvals than computer science professors. We will use the data solely on RateMyProfessors.com as a random sample of information given to students before students decide upon a class/major every quarter/semester. 

Based on the research and results, we can interpret and analyze data to show if the hypothesis is true and use the appropriate filters to visualize the data and add it to the final report. We hope that this research will ultimately lead to a different way of teaching Computer Science courses in order to attract and retain more students in Computer Science and other physical sciences and Engineering. 

Steps:
1. Analyze what data is available: Professor, Major, University, Rating, Easiness
2. Create own MySQL database. Create tables, relations: University, Professor, Rating
3. "Scrape" RateMyProfessors.com to get data in our own database.
5. Test hypothesis, T-test and other statistics approaches
4. Find dependencies/patterns between majors and ratings. 
5. Represent/visualize data on web with different presentation (by university, subject,state, etc.)
7. Optimize Database to make web-querying work faster.
8. Publish results on the web.

Future:
Update data constantly going forward, and add more data sources.
It would be interesting to find college grads by major to see if there is a correlation between ratings on RateMyProfessors.com and the graduate statistics.

Educational Objectives:
This project involves many aspects such as database design and connectivity, web application design and development, parsing XML/JSON, website scraping, and data filtering with MySQL Database queries. I will use my knowledge I have acquired in courses such as ECS 165A and ECS 165B, and work experience with web design and development, databases, and data analysis. This project will give me the opportunity to enhance my experience with relational databases, web scraping, databases, database connectivity, web application development, and data filtering. I hope that this research experience will broaden my understanding of these Computer Science principles that I have learned. I will use ideas I have learned as an undergrad to apply to new programming languages, Cloud & web application frameworks, Databases, and Web Servers.
