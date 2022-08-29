from flask import Flask, request,jsonify
import pyrebase


app = Flask(__name__)

firebaseConfig = {
  "apiKey": "AIzaSyDRmFjrXTKsKmwWbH7DoKX232Tv8Ab9U54",
  "authDomain": "registrysystem-b5d4a.firebaseapp.com",
  "projectId": "registrysystem-b5d4a",
  "storageBucket": "registrysystem-b5d4a.appspot.com",
  "messagingSenderId": "960666889058",
  "appId": "1:960666889058:web:7fb6fc98435c3ebb8a9a3b",
  "measurementId": "G-FCEJ3Z1Q6K",
  "databaseURL":"https://registrysystem-b5d4a-default-rtdb.firebaseio.com/"
};

firebase=pyrebase.initialize_app(firebaseConfig)



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
           