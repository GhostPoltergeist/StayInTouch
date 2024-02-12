import os
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText


def getFromConfig():
    # Get the user's home directory
    user_home = os.path.expanduser("~")

    # Get the path to the Desktop directory
    desktop_path = os.path.join(user_home, 'Desktop')

    # Construct file paths relative to the Desktop directory
    subject_file_path = os.path.join(desktop_path, 'INF_LOGS', 'settings', 'SUBJECT.txt')
    message_file_path = os.path.join(desktop_path, 'INF_LOGS', 'settings', 'MESSAGE.txt')
    receivers_file_path = os.path.join(desktop_path, 'INF_LOGS', 'logs', 'RECEIVER_EMAILS.txt')

    # Read subject from SUBJECT.txt
    with open(subject_file_path, 'r') as subject_file:
        subject = subject_file.read().strip()

    # Read message from MESSAGE.txt
    with open(message_file_path, 'r') as message_file:
        message = message_file.read().strip()

    # Read receiver emails from RECEIVER_EMAILS.txt
    with open(receivers_file_path, 'r') as receivers_file:
        receiver_emails = [line.strip() for line in receivers_file.readlines()]

    sender_txt_path = os.path.join(desktop_path, 'INF_LOGS', 'config', 'SENDER.txt')
    try:
        with open(sender_txt_path, 'r') as sender_file:
            lines = sender_file.readlines()
            if len(lines) >= 2:
                sender_email = lines[0].strip()
                sender_password = lines[1].strip()
            else:
                raise ValueError()
    except FileNotFoundError:
        raise FileNotFoundError()

    return sender_email, sender_password, receiver_emails, subject, message


def MimeObject(sender_email, receiver_emails, subject, message):
    msg = MIMEMultipart()
    msg['From'] = sender_email
    msg['To'] = ', '.join(receiver_emails)
    msg['Subject'] = subject
    msg.attach(MIMEText(message, 'plain'))

    return msg


def SMPTSending(sender, receiver_emails, message):
    smtp_server = 'smtp.gmail.com'
    smtp_port = 587

    # Get the user's home directory
    user_home = os.path.expanduser("~")

    # Get the path to the Desktop directory
    desktop_path = os.path.join(user_home, 'Desktop')

    sender_txt_path = os.path.join(desktop_path, 'INF_LOGS', 'config', 'SENDER.txt')

    try:
        with open(sender_txt_path, 'r') as sender_file:
            lines = sender_file.readlines()
            if len(lines) >= 2:
                smtp_username = lines[0].strip()
                smtp_password = lines[1].strip()
            else:
                raise ValueError()
    except FileNotFoundError:
        raise FileNotFoundError()

    server = smtplib.SMTP(smtp_server, smtp_port)
    server.starttls()

    try:
        server.login(smtp_username, smtp_password)
    except smtplib.SMTPAuthenticationError as e:
        error_message = e.smtp_error.decode() if hasattr(e, 'smtp_error') else str(e)
        if "BadCredentials" in error_message:
            print("SMTP Authentication Error: The username or password is not accepted.")
        else:
            print("SMTP Authentication Error:", error_message)
    except Exception as e:
        print("An error occurred:", e)

    for receiver_email in receiver_emails:
        server.sendmail(sender, receiver_email, message.as_string())

    server.quit()


if __name__ == "__main__":
    email, password, receiver_emails, subj, msg = getFromConfig()
    mimeMSG = MimeObject(email, receiver_emails, subj, msg)
    SMPTSending(email, receiver_emails, mimeMSG)
