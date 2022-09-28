INSERT INTO product (id, quantity, price, description, image, name, featured) VALUES (
    1,
    40,
    80.00,
    'Classic 100% organic cotton Revature branded black sweatshirt',
    'https://s3bucketrt34.s3.amazonaws.com/revsweatshirt.png',
    'Revature Sweatshirt',
    false
),
(
    2,
    35,
    80.00,
    'Classic 100% organic cotton HTML5 branded navy blue sweatshirt',
    'https://s3bucketrt34.s3.amazonaws.com/revsweatshirt2.png',
    'HTML5 Sweatshirt',
    false
),
(
    3,
    35,
    80.00,
    'Classic 100% organic cotton React branded sweatshirt',
    'https://s3bucketrt34.s3.amazonaws.com/revsweatshirt3.png',
    'React Sweatshirt',
    false
),
(
    4,
    35,
    35.00,
    'If you are going to code all night, you might as well do it in comfort while maintaining that prerequisite sense of humor!',
    'https://s3bucketrt34.s3.amazonaws.com/coder_jammies-rev.png',
    'Pajamas',
    false
),
(
    5,
    20,
    30.00,
    'Love React?  Show everyone with this stylish T!',
    'https://s3bucketrt34.s3.amazonaws.com/react_tshirt-rev.png',
    'React T-Shirt',
    false
),
(
    6,
    40,
    30.00,
    'Programming at the local cafe?  Have a cup of java while showing off your love for Java with this cool T',
    'https://s3bucketrt34.s3.amazonaws.com/spring_tshirt-rev.png',
    'Spring Boot T-Shirt',
    false
),
(
    7,
    15,
    250.00,
    'If you love LEDs, this is the keyboard for you',
    'https://s3bucketrt34.s3.amazonaws.com/RGB_Keyboard.png',
    'LED Rounded-key Keyboard',
    false
), 
(
    8,
    12,
    175.00,
    'work on your coding in comfort and efficiency with this beautiful keyboard.  It has a padded wrist rest and can be programmed with macros to supercharge your coding experience!',
    'https://s3bucketrt34.s3.amazonaws.com/keyboard-rev.png',
    'Razer Keyboard',
    false
),
(
    9,
    50,
    80.00,
    'LED backlit keyboard with classic hard clicking keys',
    'https://s3bucketrt34.s3.amazonaws.com/715XLKbQnFL._AC_SX679_.png',
    'LED Classic Keyboard',
    false
),
(
    10,
    40,
    170.00,
    'Classic styled mouse with LED lighting and extra side buttons by Razor',
    'https://s3bucketrt34.s3.amazonaws.com/RazorMouse.png',
    'Razor Mouse',
    false
),
(
    11,
    6,
    450.00,
    'The T is for terrific!',
    'https://s3bucketrt34.s3.amazonaws.com/T_Mouse.png',
    'T Mouse',
    false
),
(
    12,
    70,
    45.00,
    'Comfortable contoured mouse that happened to fall off of an Amazon delivery truck',
    'https://s3bucketrt34.s3.amazonaws.com/AmazonMouse1.png',
    'Amazon Basics Mouse',
    false
),
(
    13,
    30,
    150.00,
    'These are great for when you refuse to listen to people talking about React',
    'https://s3bucketrt34.s3.amazonaws.com/71o8Q5XJS5L._AC_SL1500_.png',
    'Angular Headphones',
    false
),
(
    14,
    38,
    260.00,
    'Handsome C++ headphones',
    'https://s3bucketrt34.s3.amazonaws.com/chlarger.png',
    'C++ Headphones',
    false
),
(
    15,
    50,
    95.00,
    'Headphones branded by one of the most iconic games of all time',
    'https://s3bucketrt34.s3.amazonaws.com/71woCid-GQL._AC_SX679_.png',
    'Doom Headphones',
    false
),
(
    16,
    50,
    350.00,
    'You cannot go wrong with a solid RAM upgrade',
    'https://s3bucketrt34.s3.amazonaws.com/Ram_RipJaws.png',
    'RipJaws DDR4 RAM Modules',
    false
),
(
    17,
    100,
    87.00,
    'Keep those coding fingers warm and ready Revanauts!',
    'https://s3bucketrt34.s3.amazonaws.com/handwarmer.png',
    'Revature Handwarmer',
    false
),
(
    18,
    35,
    100.00,
    'Limited edition Revature Alexandra mug',
    'https://s3bucketrt34.s3.amazonaws.com/alexandra.png',
    'Alexandra Mug',
    false
),
(
    19,
    35,
    100.00,
    'Limited edition Revature Ben mug',
    'https://s3bucketrt34.s3.amazonaws.com/ben.png',
    'Ben Mug',
    false
),
(
    20,
    35,
    100.00,
    'Limited edition Revature Jonathan humor mug',
    'https://s3bucketrt34.s3.amazonaws.com/johnathan.png',
    'Jonathan Humor Mug',
    false
),
(
    21,
    35,
    100.00,
    'Limited edition Revature Jonathan mug',
    'https://s3bucketrt34.s3.amazonaws.com/johnathan2.png',
    'Jonathan Mug',
    false
),
(
    22,
    35,
    100.00,
    'Limited edition Revature Kevin mug',
    'https://s3bucketrt34.s3.amazonaws.com/kevin.png',
    'Kevin Mug',
    false
),
(
    23,
    35,
    100.00,
    'Limited edition Revature Kevin humor mug',
    'https://s3bucketrt34.s3.amazonaws.com/kevin2.png',
    'Kevin Humor Mug',
    false
),
(
    24,
    35,
    100.00,
    'Limited edition Revature Stephen mug',
    'https://s3bucketrt34.s3.amazonaws.com/stephen.png',
    'Stephen Mug',
    false
);

INSERT INTO users (email, password, first_name, last_name, admin) VALUES (
    'testuser@gmail.com',
    'password',
    'Test',
    'User',
    false
),
(
    'testadmin@gmail.com',
    'password',
    'Test',
    'Admin',
    true
);