function createUser() {
  const user = {
    name: document.getElementById("name").value,
    address: document.getElementById("address").value,
    emailId: document.getElementById("emailId").value,
    phoneNo: document.getElementById("phoneNo").value,
    username: document.getElementById("username").value
  };

  fetch("http://localhost:8081/user", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user)
  })
  .then(res => {
    if (!res.ok) {
      return res.text().then(text => { throw new Error(text) });
    }
    return res.json();
  })
  .then(data => {
    console.log("User created:", data);
    alert(data.message);
  })
  .catch(err => console.error("Error creating user:", err));
}

function getAllUsers() {
  fetch("http://localhost:8081/users")
    .then(res => res.json())
    .then(data => {
      const list = document.getElementById("userList");
      list.innerHTML = "";
      data.data.forEach(user => {
        const item = document.createElement("li");
        item.textContent = `${user.userId} - ${user.name} (${user.emailId}, ${user.phoneNo}, ${user.address}, ${user.username})`;
        list.appendChild(item);
      });
    })
    .catch(err => console.error("Error fetching users:", err));
}
