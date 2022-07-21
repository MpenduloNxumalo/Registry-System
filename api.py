from re import S
from turtle import st
from flask import Flask, request,jsonify
from flask_pymongo import PyMongo

app = Flask(__name__)

app.config["SECRET_KEY"] = 'e79648de942a6a153bb4be3409df7def8322b1ec'
app.config["MONGO_URI"] = "mongodb+srv://MpenduloNxumalo:Dudezile1234@registry-system.1sjro.mongodb.net/?retryWrites=true&w=majority"

mongodb_client = PyMongo(app)
db = mongodb_client.db


state = 0

def switchState(s):
    global state
    state = s



#Client end points(i.e teacher)
@app.route('/active', methods=["GET"])
def active():

    res = jsonify({"activity_state": state})
    
    return res






@app.route('/createregister', methods=['GET'])
def createregister():

    switchState(1)
    res = state
    return str(res) 




@app.route('/generate_report', methods=['POST'])
def generate_report():

    req = request.get_json()
    print(req)

    switchState(0)
    res = state
    return str(res)



@app.route('/attendees')
def attendees():
    return

    



if __name__ == '__main__':
    app.run(debug=True)
           