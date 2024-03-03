# EmailSender (StayInTouch) StandAlone Version 

**Author:** Harold Edsel F. Cabaluna

The *EmailSender* Jython script is a tool designed to simplify the process of sending multiple emails using Python and Java. This script leverages the power of Python's `smtplib` library to send emails programmatically, making it useful for various applications such as automating notifications, sending reports, or communicating with users.

## Features

- Send emails to one or more recipients.
- More Features in next Version

## Prerequisites

Before using the EmailSender script, ensure you have the following prerequisites:

- Python 3.x installed on your system.
- A valid email account from which you want to send emails.
- Internet connectivity to establish a connection with the email server.

## Installation

1. Clone or download the repository to your local machine. git clone https://github.com/GhostPoltergeist/EmailSender.git

2. Navigate to the latest Releases and Download
```latestVersion.exe```

3. Install the required JDK Version:
```JDK 17.0 - 21.0```

## Usage

1. This latest vesion will allow you to send emails more quicker than the ealier version
2. Follow the instructions carefully when it comes to Sender Password it requires some changes in your Gmail Security

## SMTP Setup
```
Generate an Application-Specific Password:

1. Go to your Google Account settings: https://myaccount.google.com/

2. In the "Security" section, find the "Signing in to Google" option.

3. Enable and Setup the 2-Step Verification first then Click on "App passwords."

5. Enter a custom name for your app, like "StayInTouch"

6. Click the copy the password generated "e.g: zxcy zxcy zxcy zxcy"

7. Now use that app password as your password for email sending. 
```

## Use the Application-Specific Password in your Code
In Sender(Password) Code, replace it EMAIL_PASSWORD variable
with the generated application-specific password you obtained from Google:
```java
SampleAppCode=xcvc xcvb bcvb xcvb
```
## Contributions
Contributions to the EmailSender Python script are welcome! If you find any issues or want to enhance its features, feel free to create a pull request.

## License
This project is licensed under the MIT License - see the LICENSE.txt file for details.

Feel free to reach out to me at EdselCabaluna21@gmail.com for any questions or suggestions! Your feedback is greatly appreciated.

   
