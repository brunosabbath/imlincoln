-- MySQL dump 10.13  Distrib 5.6.26, for osx10.8 (x86_64)
--
-- Host: localhost    Database: events
-- ------------------------------------------------------
-- Server version	5.6.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `description` varchar(1500) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `price` varchar(200) DEFAULT NULL,
  `venue_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `venue_id` (`venue_id`),
  KEY `name_index` (`name`),
  KEY `end_date_index` (`end_date`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`venue_id`) REFERENCES `venue` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (191,'&quot;Football,&quot; The Exhibit','\nTime: Thu, Dec 3 2015, All Day\nFootball arrives at the Strategic Air & Space Museum on October 3. Join us for a Football Tailgate Party from noon-2 p.m. \"Football\" a popular traveling exhibit, offered by the Museum of Discovery, is a 3,000 square foot exhibit that introduces visitors to the science, mathematics and technology behind the game and how they relate to our everyday lives. This highly interactive exhibit provides hands-on learning covering a wide array of science topics through football themed areas such as Forward Pass and Game at the Line of Scrimmage. Website: http://sasmuseum.com/events/','28210 West Park Hwy (I-80, Exit #426)','2015-12-03 02:00:00','2016-01-02 02:00:00','Standard Museum admission fees: Adults $12.00 / Senior Citizens $11.00 (65 +) / Active/Retired Military $11.00 / Children $6.00 (Ages 4 to 12)',151),(192,'“Holiday of Trees” Student Holiday Performances','\nTime: Thu, Dec 3 2015, 10:00 am - 8:00 pm CST\nRepeats every day until Friday, December 04, 2015\nThe Lincoln Music Teachers Association invites you to attend the “Holiday of Trees.”  While admiring the decorated tress enjoy background music by LMTA students and teachers.  Ticket sales this year will benefit Fresh Start. Fresh Start provides a safe, structured, alcohol and drug free environment for women invested in attaining self-sufficiency.  Fresh Start provides transitional housing and services to homeless women without children in their custody.  Tickets available at the door. Website: https://sites.google.com/site/heritageleaguelincoln/','2110 Sheridan','2015-12-03 12:00:00','2015-12-04 22:00:00','$1',152),(193,'NWU High School Art Exhibition','\nTime: Thu, Dec 3 2015, 10:00 am - 4:00 pm CST\nRepeats every day until Thursday, December 10, 2015\nGallery hours: Tuesday-Friday, 10 a.m.-4 p.m.; Saturday-Sunday, 1-4 p.m.','50th Street and Huntington Avenue','2015-12-03 12:00:00','2015-12-10 18:00:00','This is a free event.',153),(194,'Clinic With A Heart -- Free Health Clinic','\nTime: Thu, Dec 3 2015, 5:30 pm - 7:00 pm CST\nFree clinic makes no appointments; all patients seen as walk-in, first-come, first-served.  Patients under age 19 must be accompanied by parent or legal guardian.  Early sign-in begins @ 2pm; waiting room opens @ 4pm; exams begin @ 5:30pm.  NO CLINIC on Christmas Eve (December 24th) or New Years Eve (December 31st).  Medical services available Tuesdays and Thursdays, Dental services only on Tuesdays. Clinic schedule and listing of available services is available on our website:  www.ClinicWithaHeart.org  or call 402-421-2924 Website: http://www.clinicwithaheart.org','1701 S. 17th St.','2015-12-03 19:30:00','2015-12-03 21:00:00','This is a free event.',154),(195,'Robert Hillestad Gallery Special Kid-Friendly Gallery Tour','\nTime: Thu, Dec 3 2015, 6:00 pm - 7:30 pm CST\nExhibit: \"Red, White & Green All Over,\" display of red and green quilts. Special event: Thursday Dec. 3 from 6-7:30 p.m. Event will highlight how traditions were - and still can be - passed down through generations, shared across cultures and borrowed from one craft for use in another.','35th Street north of East Campus Loop','2015-12-03 20:00:00','2015-12-03 21:30:00',NULL,155),(196,'Geeks Who Drink. Pub Trivia. 6 person teams','\nTime: Thu, Dec 3 2015, 7:00 pm - 9:00 pm CST\nRepeats every week on Thursday until Thursday, December 17, 2015\nEvery Tuesday from 7-9 pm in the Ploughshare Brewing Co. Loft - It\'s Geeks Who Drink! The best pub trivia game for geeks, nerds, dweebs and dorks. Six-person teams. Get there early to register your team. Our quiz burns through nearly 70 multimedia questions in two exciting hours. Our quizmaster gets to know the players, and smack talk flying around in all directions is pretty much par for the course. Plus you win prizes, including FREE beer and schwag. Website: http://www.ploughsharebrewing.com','1630 P Street','2015-12-03 21:00:00','2015-12-17 23:00:00','This is a free event.',156),(197,'America\'s Pub Quiz','\nTime: Thu, Dec 3 2015, 7:00 pm - 9:00 pm CST\nRepeats every week on Thursday until Thursday, November 24, 2016\nAmerica\'s Pub Quiz puts on live trivia nights at pubs, bars and restaurants across the United States. We are happy to bring fun trivia to family, friends and co-workers. An entertaining evening to be had by all – guaranteed! How can we guarantee this? It’s FREE to play! We are so confident in your enjoyment that we aren’t going to charge you anything to play AND provide FREE nightly prizes and regular cash tournaments.     Website: http://www.americaspubquiz.com','124 N 13th St','2015-12-03 21:00:00','2016-11-24 23:00:00','This is a free event.',157),(198,'The Moon Songwriters Open Mic Night, featuring Jordan Morris','\nTime: Thu, Dec 3 2015, 7:00 pm CST\nOpen mic follows Jordan Morris performance','140 N. Eighth St., lower level','2015-12-03 21:00:00','2015-12-03 02:00:00','This is a free event.',158),(199,'Dickens &quot;A Christmas Carol&quot; -- NWU Production','\nTime: Thu, Dec 3 2015, 7:30 pm CST\nNWU Theatre tradition continues with miserly Scrooge, a trio of frightening and enlightening ghosts and a whole lot of good cheer.','51st Street and Huntington Avenue','2015-12-03 21:30:00','2015-12-05 02:00:00',NULL,159),(200,'&quot;Driving Miss Daisy,&quot; TADA Producations','\nTime: Thu, Dec 3 2015, 7:30 pm CST\nThe TADA Theatre proudly presents the Pulitizer Prize winning play \"Driving Miss Daisy,\" Dec. 3-6 and 10-13. Winner of the Outer Critics Award for Best Off-Broadway Play, \"Driving Miss Daisy,\" written by Alfred Uhry, is a warm-hearted, humorous and affecting story of the unlikely relationship between an aging, crotchety Southern lady, and her proud, soft-spoken chauffeur. What begins as a troubled pairing soon blossoms into a profound, life-altering friendship that transcends all the societal boundaries placed between them. Cast members: Jeanne Kern as Daisy Werthan; William Bryant as Hoke Coleburn and Lynn Leach as Boolie Werthan. Director, Robert D. Rook; scenic design and painting, Jenna Manley; costume coordination, Cris Rook; hair and make-up, Cathy Rook; properties, Jenna Manley; seamstress, Stephanie Tolliver.','701 P St. (The Creamery Building','2015-12-03 21:30:00','2015-12-05 02:00:00','$18/adults, $15/students',160),(201,'Wet Ink!','\nTime: Thu, Dec 3 2015, 7:30 pm - 8:30 pm CST\nFree and open to the public. Website: http://music.unl.edu','Westbrook Recital Hall','2015-12-03 21:30:00','2015-12-03 22:30:00','This is a free event.',161),(202,'Pitch, Please! Fall Show','\nTime: Thu, Dec 3 2015, 7:30 pm CST\nUNL\'s premiere coed a cappella group.','1400 R St.','2015-12-03 21:30:00','2015-12-03 02:00:00','$5',162),(203,'&quot;Mary\'s Wedding&quot; UNL Theatrix','\nTime: Thu, Dec 3 2015, 7:30 pm CST\nUNL Theatrix presents Website: http://unltheatretickets.com','Third Floor Temple Bldg. UNL 12th &amp; R','2015-12-03 21:30:00','2015-12-05 02:00:00','$6',163),(204,'&quot;Christmas in the City&quot; with Lorie Line','\nTime: Thu, Dec 3 2015, 7:30 pm CST\nThis year\'s show will take you to three different and memorable cities to celebrate Christmas. The last stop will put you in downtown Minneapolis, Lorie\'s hometown, where she will take you back in time to the good ol\' days of Dayton\'s where many of you first discovered her. She is bringing back the famous medley, so start thinking of your favorite song and be ready to shout it out so she can play if for you. Lorie will be bringing her Fab Five and a special featured vocalist.','301 N. 12th St.','2015-12-03 21:30:00','2015-12-03 02:00:00','$49',164),(205,'G.I. Holiday Jukebox','\nTime: Thu, Dec 3 2015, 7:30 pm - 9:30 pm CST\nRepeats every week on Thursday, Friday, and Saturday until Saturday, December 19, 2015\nJoin us this Holiday Season as we invite you to be \"one of the boys\" where you\'ll enjoy one final show before being shipped off to the European front. Our talented cast of four will make your holidays \"merry & bright\" in this review-style USO show of 1940s WWII-era songs - of both standards and Holiday Classics alike, including tunes such as \"Boogie Woogie Bugle Boy,\" \"Don\'t Sit Under the Apple Tree,\" \"Jingle Bells\" and \"Silent Night.\" Written by Rick Lewis, G.I. HOLIDAY JUKEBOX is under the direction of Robert Wamsley, assistant directed by Emmy Lou Harris, with music direction by Tim Frey and choreography by Jessica Connelly. Performances are December 3rd-6th, 10th-13th & 17th-20th. Tickets: Stage Theater box office, 402.512.1808 or visit our website:www.thestagetheater.com for reservations. Website: http://www.thestagetheater.com','225 Locust Street','2015-12-03 21:30:00','2015-12-19 23:30:00','$11, $14, $16',165),(206,'Karaoke: Fuzzy\'s Taco Shop','\nTime: Thu, Dec 3 2015, 8:00 pm - 2:00 am CST\nRepeats every week on Thursday until Thursday, January 07, 2016\nKaraoke Thursdays are back! Sing your heart out every Thursday at 8pm at Fuzzy\'s Taco Shop. Don\'t forget the margaritas! Website: https://www.facebook.com/fuzzyslincoln','1442 O Street','2015-12-03 22:00:00','2016-01-07 04:00:00','This is a free event.',166),(207,'Karaoke: Shoooters Bar &amp; Grill with On The Road Again Karaoke','\nTime: Thu, Dec 3 2015, 8:00 pm - 1:00 am CST\nRepeats every week on Thursday until Friday, January 01, 2016\nLive Karaoke.','300 West P Street','2015-12-03 22:00:00','2016-01-01 03:00:00','This is a free event.',167),(208,'An Irish Christmas','\nTime: Thu, Dec 3 2015, 8:00 pm - 10:00 pm CST\nAn Irish Christmas brings just about everything to the table – joy, hope, laughter, friendship, celebration, of life through storytelling, music, song, and dance in a night that sparkles with life and a bit of ‘magic!’ Dancers dance through the generations over brooms, on half doors, around butter churns, into the world of mythology and out again. Songs spinning out of the mists and into the familiar Silent Night, Little Drummer Boy and Carol of the Bells, and superb music of the pipes, flutes, fiddles, button accordion and bodhráns are just the beginning of this great Irish night! $35/general seating, $25/student and youth. All ages welcome (under 16 must be accompanied by adult). Students must bring valid ID and youth must be 12 or younger. Website: http://www.rococotheatre.com','The Rococo Theatre','2015-12-03 22:00:00','2015-12-04 00:00:00','$35/general, $25/students and youth',168),(209,'Comedy Underground with Brad Stewart','\nTime: Thu, Dec 3 2015, 8:00 pm - 9:00 pm CST\n\"So talented. A joy to work with\" -Joan Rivers \"A Comedian to Watch\" -Marlo Thomes, Huffington Post  Brad Stewart began his comedy career shortly after moving to Los Angeles from Nebraska in 1995 and winning 1st place in comedy contest. He beat out hundreds of comedians to win $500. Brad used it to register his car in California. Since that time Brad has performed at many different clubs and theaters all over the country to rave reviews. From The Nokia Theater in Los Angeles to the Hilton Casino in Atlantic City, Brad has entertained many diverse audiences with his high energy, observational style of humor.  In early 2010 Brad had the honor of becoming a favorite opening act for comedy legend Joan Rivers.  Brad has also opened for The Temptations, Jon Lovitz, Keith Sweat, Rob Schneider, The O\'Jays, Barry Manilow, and 80\'s rockers Loverboy.  Brad\'s comedy is a mix of his observations about life and his love/hate relationship with pop culture. Music is a big love of Brad\'s and a lot of his comedy comes from his frustrations with the state of popular music which should be relatable to anyone with ears. Website: https://www.facebook.com/events/177610612587384/','201 N. 8th St.','2015-12-03 22:00:00','2015-12-03 23:00:00','$5',169),(210,'RITTZ with Urban Outlaws, Cartel TZ, DJ D-Luv','\nTime: Thu, Dec 3 2015, 9:00 pm CST\nLive music','1415 O St.','2015-12-03 23:00:00','2015-12-03 02:00:00',NULL,170),(211,'Mushroomhead with 9Electirc, Unsaid Fate','\nTime: Thu, Dec 3 2015, 9:00 pm CST\nLive music','350 Canopy St.','2015-12-03 23:00:00','2015-12-03 02:00:00',NULL,171),(212,'Terrestrial Sector, Tommy O\'Keffee','\nTime: Thu, Dec 3 2015, 9:00 pm CST\nLive music','901 O St.','2015-12-03 23:00:00','2015-12-03 02:00:00',NULL,172),(213,'Son of \'76 Duo featuring Josh Hoyer and Werner Althaus','\nTime: Thu, Dec 3 2015, 9:30 pm CST\nLive music','136 N. 14th St.','2015-12-03 23:30:00','2015-12-03 02:00:00','$5',173),(215,'Kamp Out for Kids','\nTime: Fri, Dec 4 2015, All Day\nJoin us for the 24th annual Kamp Out for Kids Event! Community Action, 104.1 The Blaze, and Spikes Beach Bar and Grille are collecting toys and cash for children and families in need this holiday season. We invite the community to join us on Friday, December 4th from 10 a.m. to midnight, and Saturday, December 5th from 8 a.m. to noon for a live broadcast with 104.1 The Blaze from Spikes Beach Bar and Grill (23rd & Judson – just off of 23rd & Cornhusker Hwy). Stop by and see us, drop off a new unwrapped toy or monetary donation, check out the silent auction items, grab a bite to eat, or head out to the Teddy Bear Toss at The Stars hockey game on Friday night, and take a stuffed toy with you to toss out onto the ice the first time The Stars score a goal! It’s quite a site! A portion of the proceeds from meals purchased at Spikes throughout Kamp Out will go back to Community Action to help those living in poverty in our community.   Check out this link for details: http://www.communityactionatwork.org/events/projects/kampout-for-kids.html Website: http://www.communityactionatwork.org/events/projects/kampout-for-kids.html','2300 Judson Street','2015-12-04 02:00:00','2015-12-04 02:00:00','This is a free event.',174),(216,'Festivus &quot;Glam Edition&quot; first holiday partay','\nTime: Fri, Dec 4 2015, 9:00 am CST\n','408 S. 11th St.','2015-12-04 11:00:00','2015-12-04 02:00:00',NULL,175),(219,'First Friday Jazz Concert Series with Andy Hall Quartet','\nTime: Fri, Dec 4 2015, 11:30 am - 1:00 pm CST\nBassist and vocalist Andy Hall and his quartet\'s \"Jazz Christmas\" concert will be featured at December\'s First Friday Jazz Concert. Andy and his group have secured themselves as one of the most popular jazz ensembles to perform for the First Friday Jazz series. Andy will be joined by Peter Bouffard on guitar, Scott Vicroy on saxophone and John Scofield on drums. The concert will be between 11:30 a.m. and 1 p.m. Audience members are invited to purchase lunch at the concert or bring their own and spend as much of their lunch hour as they wish listening to jazz. Donations of non-perishable food items for the Food Pantry is encouraged and welcome.','1551 S. 70th St.','2015-12-04 13:30:00','2015-12-04 15:00:00','This is a free event.',176),(220,'First Friday Concert Arts Series with Nebraska Wesleyan Chamber Singers','\nTime: Fri, Dec 4 2015, 12:10 pm CST\nCelebrating an Elizabethan Christmas with the NWU Chamber Singers, directed by William A. Wyman, who are assisted by trumpet consort, recorder consort and Comedia del Arte all from the music and theater departments of NWU. Art by the NWU Art Department will be exhibited in Paine Parlor and will remain in place for the entire month. The McKinley Bells, played by Brent Shaw, will be heard from the church tower prior to the concert and also broadcast into the Sanctuary. The concert begins at 12:10 p.m. Lunch is available for $6 in the dining room. Saint Paul\'s traditional cookie walk in the dining room from 10 a.m.-2 p.m. --- $10/box.','1144 M St.','2015-12-05 01:10:00','2015-12-04 02:00:00','This is a free event.',177),(221,'CEHS Food Drive Dec. 3-15','The College of Education and Human Sciences is hosting a collegewide food drive for the Food Bank of Lincoln from Dec. 3-15. Donation barrels will be placed in Henzlik Hall, Teachers College Hall, Mabel Lee Hall, Home Economics Building, and Leverton Hall.\r\n\r\nOur goal is to reach 500 donated food items. If we reach that goal, we will celebrate with donuts on Jan. 11 in the Home Economics Building and Henzlik Hall. Cash donations may also be made in either Dean’s Office. A $1 donation equals 1 food item.\r\n\r\nTake a selfie while dropping an item in a CEHS donation barrel and post it on Facebook, Twitter, or Instagram to be entered in a drawing for a gift card. Use #CEHSFoodDrive and tag our social media page on your posts (they must be public for us to see them):\r\nFacebook: UNL College of Education and Human Sciences\r\nTwitter: @UNL_CEHS\r\nInstagram: @UNL_CEHS\r\nPlease join us in collecting canned and dry goods to help individuals and families in the Lincoln area have a better holiday season.','College of Education and Human Sciences','2015-12-04 02:00:00','2015-12-16 02:00:00',NULL,178),(223,'Seminar Series – Department of Agricultural Economics',' Presented by Brent Gloy.','Filley Hall','2015-12-04 17:00:00','2015-12-04 18:30:00',NULL,179),(224,'First Friday at Sheldon Museum of Art with the UNL Chamber Singers','The University of Nebraska’s Glenn Korff School of Music Chamber Singers will, once again, give a brief performance at the Sheldon Art Museum’s FIRST FRIDAY celebration at 5 p.m. on December 4th.\r\n\r\nThe program will include festive music suitable to the occasion and appropriate to the upcoming Holiday Season.\r\n\r\nFollowing a few selections in the main hall, the singers, joined by an 8-piece brass ensemble will reconvene in the auditorium with comfortable seating and recital stage.\r\n\r\nThe Chamber Singers consist of 28 of UNL’s finest singers conducted by Earl “Pete” Jenkins Endowed Visiting Choral Artist Dr. Eph Ehly. ','Sheldon Museum of Art','2015-12-04 19:00:00','2015-12-04 19:00:00',NULL,180),(225,'Mary\'s Wedding','It is the night before Mary\'s wedding and what can a bride-to-be do but dream? But it is WWI and changing tides stir nightmares and heartbreak. ','Temple Building','2015-12-04 21:30:00','2015-12-04 21:30:00',NULL,181),(226,'Student Dance Project','Have you ever wondered what modern dance is and/or what it looks like? Take a study break or have a night on the town and come down to watch the University of Nebraska-Lincoln Glenn Korff School of Music’s Dance Program’s 11th annual Student Dance Project at Mabel Lee Hall Dance Space (840 N. 14th Street) on December 4 and 5 at 7:30 p.m. \r\n\r\nAll 15 student choreographed pieces are unique and individualized. From Shaylee Schroeder’s piece, which uses a compilation of cave noises, to Jacqueline Adair’s using grassroots instrumentals, there is more than enough to entertain you! There is political work, there is tender work, and there may even be a laugh or two. These dances are all completely original works of art that you have never seen before.  Come and enjoy the vision of these emerging choreographers.  They are the future, and it is happening at the Student Dance Project.\r\n\r\nTickets are available at the door: General Admission $5; Students/Seniors $3. The December 5 performance will also be live webcast: http://arts.unl.edu/music/webcasts\r\n','Mabel Lee Hall','2015-12-04 21:30:00','2015-12-04 21:30:00',NULL,182),(227,'Bathtub Dogs Fall Concert','The fall semester at UNL is quickly winding down, but the 16 members of the University’s premier all-male a cappella group, the Bathtub Dogs, have been busy preparing for much more than final exams. Since August, the ‘Dogs’ have been diligently rehearsing in preparation for their semester concert, and they could not be more excited to show the public what they have been working towards.\r\n\r\nA Cappella is a unique style of music that has recently picked up a lot of positive attention in pop culture, and if you’ve been lucky enough to see the boys perform live, you know it’s no easy feat. The concert will feature both old and new music, but will also air a few absurdly silly original short films which will take the audience on a journey through ‘a day in the life of a Bathtub Dog’ (Get it?).\r\n\r\nIn addition to singing and showing films, the Bathtub Dogs will be unveiling a new holiday line of merchandise, including the usual studio albums, with the addition of branded drink koozies, tshirts, sweatshirts, and a 2016 calendar complete with 12 original photos of the Dogs being as wacky as ever. Additionally, the Bathtub Dogs have teamed up with the “Love Your Melon” apparel brand to sell hats which benefit children battling cancer in America.\r\n\r\nFor more information, visit the Bathtub Dogs’ website (bathtubdogs.com) or find them on Facebook and Twitter.  ','Nebraska Union','2015-12-04 22:00:00','2015-12-04 22:00:00',NULL,183),(239,'Cocoa and Carols','The traditional UNL choirs will combine for an exciting holiday-inspired massed choral performance of seasonal favorites titled COCOA & CAROLS: A FAMILY YULETIDE FESTIVAL OF CHOIRS. Combined will be UNL’s University Singers, the Women’s Chorale, the Varsity Men’s Chorus, Chamber Singers, and Collegiate Choir. Special guests will be the Lincoln East High School “East Singers”, under the direction of Brett Epperson. \r\n\r\nThe concerts are scheduled for 3pm and 7:30pm. Tickets are available at the door. General Admission $5; Student/Seniors $3','Kimball Recital Hall','2015-12-06 17:00:00','2015-12-06 17:00:00',NULL,186),(246,'Health Promotion Wellness Booth–East Campus','Stop by the University Health Center booth to receive information on important health and wellness topics, as well as fun health and wellness items.','East Union','2015-12-07 13:30:00','2015-12-07 14:30:00',NULL,187),(247,'Wind Ensemble','With our imaginations fueled by tales of adventure on the big screen, the UNL Wind Ensemble will follow Tinker Bell in flight, join Ahab on the deck of the Pequod, and get lost in space with Robby the Robot. And, in the heart of darkness (literally), the ensemble will accompany F. W. Murnau’s 1926 masterpiece of expressionistic cinema, Faust, with a contemporary score by Huck Hodge. Don’t miss this special evening of epic drama and unforgettable characters.','Kimball Recital Hall','2015-12-07 21:30:00','2015-12-07 21:30:00',NULL,186),(254,'Health Promotion Wellness Booth–City Campus','Stop by the University Health Center booth to receive information on important health and wellness topics, as well as fun health and wellness items. ','Nebraska Union','2015-12-08 14:00:00','2015-12-08 15:00:00',NULL,183),(255,'Symphonic Band','Join the Symphonic Band conducted by Tony Falcone with Graduate Teaching Assistant conductor Bradley Nelsen for their program entitled Musica Sacra. Works by Joaquin Turina, David Maslanka, Yo Goto, David Holsinger and Alfred Reed will be featured.\r\n\r\nThe Symphonic Band, directed by Anthony Falcone, has the distinction of being the band program’s top symphonic ensemble. Its select mission is to provide instrumentalists with an opportunity to demonstrate and develop the techniques and musical instincts appropriate to a symphonic setting.','Kimball Recital Hall','2015-12-08 21:30:00','2015-12-08 21:30:00',NULL,186),(263,'Campus Orchestra','The Campus Orchestra, directed by Tyler White, is the string players\' counterpart to the other Glenn Korff School of Music ensembles that do not require auditions and cater to the non-music major crowd, such as Campus Band and various choral ensembles.','Kimball Recital Hall','2015-12-09 21:30:00','2015-12-09 21:30:00',NULL,186),(272,'HIV Test Site','The University Health Center offers free and confidential HIV testing. Results in 20 minutes. Sponsored by the University Health Center, OASIS, and Students for Sexual Health.\r\n','Jackie Gaughan Multicultural Center','2015-12-10 14:00:00','2015-12-10 16:00:00',NULL,188),(273,'SBS Seminar: Mike Ryan, University of Texas',' “Cognition and Sexual Selection: How the Brain Biases Mate Choice”\r\n\r\nThe School of Biological Sciences Seminar is a weekly series presented by invited speakers and UNL faculty to showcase current research advances in biological sciences.','Hamilton Hall','2015-12-10 17:30:00','2015-12-10 18:30:00',NULL,189);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_has_tag`
--

DROP TABLE IF EXISTS `event_has_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_has_tag` (
  `event_id` bigint(20) unsigned NOT NULL,
  `tag_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`event_id`,`tag_id`),
  KEY `tag_id` (`tag_id`),
  CONSTRAINT `event_has_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`),
  CONSTRAINT `event_has_tag_ibfk_3` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_has_tag`
--

LOCK TABLES `event_has_tag` WRITE;
/*!40000 ALTER TABLE `event_has_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_has_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'role'),(2,'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'nightlife'),(2,'morning'),(3,'afternoon'),(4,'openair'),(5,'huskers'),(6,'unl');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `name_index` (`name`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Bruno','bvrsilva1@gmail.com','teste',2),(2,'Ceren','cerenkaplan@gmail.com','teste',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_event`
--

DROP TABLE IF EXISTS `user_has_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_event` (
  `user_id` bigint(20) unsigned NOT NULL,
  `event_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`event_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_has_event_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_has_event_ibfk_3` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_event`
--

LOCK TABLES `user_has_event` WRITE;
/*!40000 ALTER TABLE `user_has_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venue`
--

DROP TABLE IF EXISTS `venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venue` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `address` varchar(150) NOT NULL,
  `address_complement` varchar(60) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `facebook` varchar(50) DEFAULT NULL,
  `twitter` varchar(50) DEFAULT NULL,
  `website` varchar(200) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `name_index` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venue`
--

LOCK TABLES `venue` WRITE;
/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` VALUES (151,'Strategic Air Command and Aerospace Museum','28210 West Park Hwy (I-80, Exit #426)',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Ashland, NE 68003'),(152,'Westminster Presbyterian Church','2110 Sheridan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, Ne 68502'),(153,'Elder Gallery, Rogers Center for Fine Arts','50th Street and Huntington Avenue',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE 68504'),(154,'Sowers Building','1701 S. 17th St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE 68502'),(155,'Robert Hillestad Textiles Gallery, UNL Home Economics Building, 2nd floor','35th Street north of East Campus Loop',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(156,'Ploughshare Brewing Co.','1630 P Street',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE 68516'),(157,'Barrymore\'s','124 N 13th St',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE 68508'),(158,'Crescent Moon Coffee','140 N. Eighth St., lower level',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(159,'MdDonald Theatre, Elder Speech and Theatre Center','51st Street and Huntington Avenue',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(160,'TADA Theatre','701 P St. (The Creamery Building',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(161,'Westbrook Recital Hall','Westbrook Music Building',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(162,'Nebraska Union Auditorium','1400 R St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(163,'Lab Theatre','Third Floor Temple Bldg. UNL 12th and R',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE 68588'),(164,'Lied Center for Performing Arts','301 N. 12th St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(165,'The Stage Theater','225 Locust Street',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Hickman, NE 68372'),(166,'Fuzzy\'s Taco Shop','1442 O Street',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, Nebraska 68508'),(167,'Shooter\'s Bar & Grill','300 West P Street',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE 68528'),(168,'The Rococo Theatre','140 N 13th St',NULL,NULL,NULL,NULL,NULL,NULL,NULL,''),(169,'Brewsky\'s Downstairs in the Haymarket','201 N. 8th St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE 68102'),(170,'Bourbon Theatre','1415 O St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(171,'Vega','350 Canopy St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(172,'Knickerbockers','901 O St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(173,'Zoo Bar','136 N. 14th St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(174,'Spikes Beach Bar and Grille','2300 Judson Street',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE 68521'),(175,'The Hot Mess','408 S. 11th St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(176,'First Lutheran Church, Activity Center','1551 S. 70th St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(177,'Saint Paul United Methodist Church Sanctuary','1144 M St.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(178,'College of Education and Human Sciences','College of Education and Human Sciences',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(179,'Filley Hall','Filley Hall',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(180,'Sheldon Museum of Art','Sheldon Museum of Art',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(181,'Temple Building','Temple Building',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(182,'Mabel Lee Hall','Mabel Lee Hall',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(183,'Nebraska Union','Nebraska Union',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(184,'Nebraska Innovation Campus Conference Center','Nebraska Innovation Campus Conference Center',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(185,'Pinnacle Bank Arena ','Pinnacle Bank Arena ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(186,'Kimball Recital Hall','Kimball Recital Hall',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(187,'East Union','East Union',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(188,'Jackie Gaughan Multicultural Center','Jackie Gaughan Multicultural Center',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE'),(189,'Hamilton Hall','639 N. 12th Street',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lincoln, NE');
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-05 12:26:17
