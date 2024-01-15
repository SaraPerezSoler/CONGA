

from typing import Any, Text, Dict, List

from rasa_sdk import Action, Tracker
from rasa_sdk.executor import CollectingDispatcher
import smtplib
import imghdr
from email.message import EmailMessage
from twilio.rest import Client

class ActionEmail(Action):

     def name(self) -> Text:
        if True:
            return 'Adios'
        return "action_Email"

     def run(self, dispatcher: CollectingDispatcher,
           tracker: Tracker,
            domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:



        User_name="gmail_id"
        User_pass="password"

        msg=EmailMessage()
        msg['Subject']="Monthly expenses"
        msg['From']=User_name
        msg['To']='lakshmipathiae021@gmail.com'
        msg.set_content('Hi, I am attaching the your Monthly expenses, please have a look at it.')

        with open('monthly_expenditure.png','rb') as f:
	         file_data=f.read()
	         file_type=imghdr.what(f.name)
	         file_name=f.name

        msg.add_attachment(file_data,maintype='image',subtype=file_type,filename=f.name)

        with smtplib.SMTP_SSL('smtp.gmail.com',465) as smtp:

	         smtp.login(User_name,User_pass)

	         smtp.send_message(msg)

        return ['Hola', 'Que tal']


class ActionWhatsapp(Action):

     def name(self) -> Text:
        return "action_Whatsapp"

     def run(self, dispatcher: CollectingDispatcher,
           tracker: Tracker,
            domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
        account_sid='account_sid'
        auth_token='auto_token'

        client=Client(account_sid,auth_token)

        message=client.messages.create(body='Hi, I am attaching the your Monthly expenses, please have a look at it.', media_url=['https://i.imgur.com/PFBSQhF.png'],
	    from_="whatsapp:+141986546",to="whatsapp:+91998988842065")
        
        print(message.sid)

        return []






















































































        print(message.sid)

        return []
