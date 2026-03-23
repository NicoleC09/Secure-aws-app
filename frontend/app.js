const BACKEND_URL = "http://localhost:8080"; // luego: https://IP_BACKEND:8443

async function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch(`${BACKEND_URL}/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ username, password })
        });

        const data = await response.text();
        document.getElementById("response").innerText = data;

    } catch (error) {
        console.error(error);
        document.getElementById("response").innerText = "Error connecting to server";
    }
}