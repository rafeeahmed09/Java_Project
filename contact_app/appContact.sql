create  database appContact;
use appContact;
create table Contacts(
    id int auto_increment primary key ,
    name varchar(100) not null ,
    Phone varchar(10) not null ,
    PersonalEmail varchar(10) not null unique ,
    workEmail varchar(200) not null unique,
    Address varchar(200) not null
);


select *
from Contacts;

insert into Contacts(id, name,Phone,PersonalEmail,workEmail,Address)
values
    (1,  'Alice Johnson',    '555-0101', 'alice.j@gmail.com',      'alice.johnson@company.com',   '123 Maple St, Springfield, IL 62701'),
    (2,  'Bob Martinez',     '555-0102', 'bob.m@gmail.com',        'bob.martinez@company.com',    '456 Oak Ave, Austin, TX 73301'),
    (3,  'Carol Williams',   '555-0103', 'carol.w@yahoo.com',      'carol.williams@company.com',  '789 Pine Rd, Denver, CO 80201'),
    (4,  'David Lee',        '555-0104', 'david.l@gmail.com',      'david.lee@company.com',       '321 Elm St, Seattle, WA 98101'),
    (5,  'Eva Brown',        '555-0105', 'eva.b@hotmail.com',      'eva.brown@company.com',       '654 Cedar Blvd, Miami, FL 33101'),
    (6,  'Frank Davis',      '555-0106', 'frank.d@gmail.com',      'frank.davis@company.com',     '987 Birch Ln, Boston, MA 02101'),
    (7,  'Grace Wilson',     '555-0107', 'grace.w@yahoo.com',      'grace.wilson@company.com',    '147 Walnut Dr, Phoenix, AZ 85001'),
    (8,  'Henry Taylor',     '555-0108', 'henry.t@gmail.com',      'henry.taylor@company.com',    '258 Spruce Way, Chicago, IL 60601'),
    (9,  'Iris Anderson',    '555-0109', 'iris.a@outlook.com',     'iris.anderson@company.com',   '369 Ash Ct, Houston, TX 77001'),
    (10, 'James Thomas',     '555-0110', 'james.t@gmail.com',      'james.thomas@company.com',    '741 Poplar St, Portland, OR 97201'),
    (11, 'Karen Jackson',    '555-0111', 'karen.j@yahoo.com',      'karen.jackson@company.com',   '852 Willow Ave, Nashville, TN 37201'),
    (12, 'Liam White',       '555-0112', 'liam.w@gmail.com',       'liam.white@company.com',      '963 Chestnut Rd, Atlanta, GA 30301'),
    (13, 'Mia Harris',       '555-0113', 'mia.h@hotmail.com',      'mia.harris@company.com',      '159 Magnolia Blvd, Dallas, TX 75201'),
    (14, 'Noah Clark',       '555-0114', 'noah.c@gmail.com',       'noah.clark@company.com',      '357 Hickory Ln, San Diego, CA 92101'),
    (15, 'Olivia Lewis',     '555-0115', 'olivia.l@outlook.com',   'olivia.lewis@company.com',    '486 Sycamore Dr, Philadelphia, PA 19101'),
    (16, 'Paul Robinson',    '555-0116', 'paul.r@gmail.com',       'paul.robinson@company.com',   '624 Redwood Way, Las Vegas, NV 89101'),
    (17, 'Quinn Walker',     '555-0117', 'quinn.w@yahoo.com',      'quinn.walker@company.com',    '735 Cypress Ct, Minneapolis, MN 55401'),
    (18, 'Rachel Hall',      '555-0118', 'rachel.h@gmail.com',     'rachel.hall@company.com',     '846 Juniper St, Detroit, MI 48201'),
    (19, 'Samuel Young',     '555-0119', 'samuel.y@hotmail.com',   'samuel.young@company.com',    '957 Sequoia Ave, Charlotte, NC 28201'),
    (20, 'Tina King',        '555-0120', 'tina.k@gmail.com',       'tina.king@company.com',       '108 Dogwood Blvd, Columbus, OH 43201');


