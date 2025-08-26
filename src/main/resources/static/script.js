function createUser() {
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;

  fetch('/user', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, email })
  })
  .then(res => res.json())
  .then(data => alert(data.message))
  .catch(err => console.error('Error creating user:', err));
}

function getAllUsers() {
  fetch('/user')
    .then(res => res.json())
    .then(data => {
      const list = document.getElementById('userList');
      list.innerHTML = '';
      data.data.forEach(user => {
        const item = document.createElement('li');
        item.textContent = `${user.name} (${user.emailId})`;
        list.appendChild(item);
      });
    })
    .catch(err => console.error('Error fetching users:', err));
}
