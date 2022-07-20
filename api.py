from flask import Flask, request,jsonify
from flask_pymongo import PyMongo

app = Flask(__name__)

app.config["SECRET_KEY"] = 'e79648de942a6a153bb4be3409df7def8322b1ec'
app.config["MONGO_URI"] = "mongodb+srv://MpenduloNxumalo:Dudezile1234@registry-system.1sjro.mongodb.net/?retryWrites=true&w=majority"


mongodb_client = PyMongo(app)

db = mongodb_client.db





#Client end points(i.e teacher)



@app.route('/createregister', methods=['POST'])
def createregister():

    req = request.json()
    
    return jsonify({"Response":req})

@app.route('/export_report', methods=['POST'])
def export_report():
    return



@app.route('/attendees')
def attendees():
    return

    
@app.route('/')
def Herman():
    return "Holla Herman!"


if __name__ == '__main__':
    app.run(debug=True)
           