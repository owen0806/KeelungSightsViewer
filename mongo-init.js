// MongoDB initialization script
// This script runs when the MongoDB container is first created
// Environment variables are available from docker-compose.yml

const dbName = "sights";
const appUser = process.env.MONGODB_APP_USER || "sightsUser";
const appPassword = process.env.MONGODB_APP_PASSWORD || "sightsPassword";

// Switch to the application database
db = db.getSiblingDB(dbName);

// Create a dedicated user for the application
db.createUser({
    user: appUser,
    pwd: appPassword,
    roles: [
        {
            role: "readWrite",
            db: dbName,
        },
    ],
});

// Create initial collections if needed
db.createCollection("sight");

print(`MongoDB initialized successfully for Keelung Sights Viewer`);
print(`Created user: ${appUser} with readWrite access to ${dbName} database`);
