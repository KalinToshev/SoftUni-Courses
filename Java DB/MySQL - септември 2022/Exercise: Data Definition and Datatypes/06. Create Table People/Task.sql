CREATE TABLE `people` (
	  `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB,
    `height` DOUBLE(10, 2),
    `weight` DOUBLE(10, 2),
    `gender` ENUM('m', 'f') NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);

INSERT INTO `people` (`name`, `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES (
		    'Kalin',
        1.75,
        120.0,
        'm',
        NOW(),
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec bibendum felis. Nunc purus risus, tempus non nisl eu, tincidunt sagittis leo. Curabitur hendrerit luctus nibh id porta. In hac habitasse platea dictumst. Pellentesque sodales lectus et nulla euismod, a viverra ipsum tincidunt. Nunc euismod, risus non aliquet lacinia, leo arcu pellentesque nulla, vitae dapibus nulla ligula in massa. Curabitur a elit imperdiet ipsum mollis rutrum. Suspendisse turpis sapien, rhoncus non imperdiet quis, sollicitudin sit amet massa. Nullam quis lectus nulla. Sed tempor porta mauris vel finibus. Donec iaculis finibus sem, vulputate placerat leo bibendum eu."
	   ),
	   (
       'Miroslav',
       1.70,
       73.5,
       'm',
       NOW(),
       "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec bibendum felis. Nunc purus risus, tempus non nisl eu, tincidunt sagittis leo. Curabitur hendrerit luctus nibh id porta. In hac habitasse platea dictumst. Pellentesque sodales lectus et nulla euismod, a viverra ipsum tincidunt. Nunc euismod, risus non aliquet lacinia, leo arcu pellentesque nulla, vitae dapibus nulla ligula in massa. Curabitur a elit imperdiet ipsum mollis rutrum. Suspendisse turpis sapien, rhoncus non imperdiet quis, sollicitudin sit amet massa. Nullam quis lectus nulla. Sed tempor porta mauris vel finibus. Donec iaculis finibus sem, vulputate placerat leo bibendum eu."
      ),
      (
       'Kristiqn',
       1.80,
       82.4,
       'm',
       NOW(),
       "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec bibendum felis. Nunc purus risus, tempus non nisl eu, tincidunt sagittis leo. Curabitur hendrerit luctus nibh id porta. In hac habitasse platea dictumst. Pellentesque sodales lectus et nulla euismod, a viverra ipsum tincidunt. Nunc euismod, risus non aliquet lacinia, leo arcu pellentesque nulla, vitae dapibus nulla ligula in massa. Curabitur a elit imperdiet ipsum mollis rutrum. Suspendisse turpis sapien, rhoncus non imperdiet quis, sollicitudin sit amet massa. Nullam quis lectus nulla. Sed tempor porta mauris vel finibus. Donec iaculis finibus sem, vulputate placerat leo bibendum eu."
      ),
      (
       'Vladislav',
       1.75,
       91.4,
       'm',
       NOW(),
       "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec bibendum felis. Nunc purus risus, tempus non nisl eu, tincidunt sagittis leo. Curabitur hendrerit luctus nibh id porta. In hac habitasse platea dictumst. Pellentesque sodales lectus et nulla euismod, a viverra ipsum tincidunt. Nunc euismod, risus non aliquet lacinia, leo arcu pellentesque nulla, vitae dapibus nulla ligula in massa. Curabitur a elit imperdiet ipsum mollis rutrum. Suspendisse turpis sapien, rhoncus non imperdiet quis, sollicitudin sit amet massa. Nullam quis lectus nulla. Sed tempor porta mauris vel finibus. Donec iaculis finibus sem, vulputate placerat leo bibendum eu."
      ),
      (
       'Momchil',
       1.95,
       61.1,
       'm',
       NOW(),
       "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec bibendum felis. Nunc purus risus, tempus non nisl eu, tincidunt sagittis leo. Curabitur hendrerit luctus nibh id porta. In hac habitasse platea dictumst. Pellentesque sodales lectus et nulla euismod, a viverra ipsum tincidunt. Nunc euismod, risus non aliquet lacinia, leo arcu pellentesque nulla, vitae dapibus nulla ligula in massa. Curabitur a elit imperdiet ipsum mollis rutrum. Suspendisse turpis sapien, rhoncus non imperdiet quis, sollicitudin sit amet massa. Nullam quis lectus nulla. Sed tempor porta mauris vel finibus. Donec iaculis finibus sem, vulputate placerat leo bibendum eu."
      );
