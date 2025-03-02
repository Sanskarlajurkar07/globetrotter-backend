# globetrotter-backend
# Globetrotter Backend

This is the backend for the Globetrotter Challenge, a full-stack web app where users guess famous destinations based on cryptic clues. It provides RESTful APIs to manage gameplay and user interactions.

## Setup

To run this project locally, follow these steps:

1. Install Prerequisites:
   - Java 21 (JDK)
   - Maven
   - MongoDB (local or MongoDB Atlas)

2. Start MongoDB:
   - Open a terminal and run `mongod` to start the local MongoDB server.
   - Ensure it’s listening on port 27017 (default).

3. Clone the Repository:
   - `git clone <your-github-repo-url>`
   - Navigate to the project directory: `cd globetrotter-backend`

4. Run the Application:
   - Use Maven: `mvn spring-boot:run`
   - Or use IntelliJ IDEA: Open the project and run `GlobetrotterBackendApplication`.

5. Verify:
   - Access the APIs at `http://localhost:8081/api/game/start` or use Postman/curl to test endpoints.

# Tech Stack

- Spring Boot 3.x: For building the RESTful backend.
- Java 21: For modern language features and performance.
- MongoDB: For storing destinations and user data.
- RESTful APIs: For communication between backend and frontend.

# APIs

#Game Endpoints

- GET /api/game/start**:
  - Description: Returns a random destination with 1–2 clues and 4 multiple-choice options.
  - Response: `{"destinationId": "...", "clues": [...], "options": [...]}` (200 OK)

- **POST /api/game/answer**:
  - Description: Submits a guess, updates the user’s score, and returns feedback with a fun fact.
  - Request: `{"username": "testUser", "destinationId": "...", "guess": "Tokyo"}`
  - Response: `{"isCorrect": true/false, "funFact": "..."}` (200 OK)

- **GET /api/game/score?username={username}**:
  - Description: Retrieves a user’s total correct and incorrect answers.
  - Response: `{"correct": n, "incorrect": n}` (200 OK)

### User Endpoints

- POST /api/users/register:
  - Description: Registers a new user or initializes their score.
  - Request: `{"username": "testUser"}`
  - Response: 200 OK (no body)

- GET /api/users/invite/{username}**:
  - Description: Generates an invite link and image URL for a user to challenge friends.
  - Response: `{"link": "...", "imageUrl": "..."}` (200 OK)

- GET /api/users/{username}/score**:
  - Description: Retrieves a user’s score (same as `/api/game/score`).
  - Response: `{"correct": n, "incorrect": n}` (200 OK)

## Deployment

The app is deployed on Railway at: `https://globetrotter-backend.up.railway.app` (update with your actual URL).

## Notes

- Ensure MongoDB is running locally or configure `application.properties` for MongoDB Atlas with `spring.data.mongodb.uri`.
- The dataset includes 100+ famous destinations stored in MongoDB’s `destinations` collection.
