
const UserAction = async() => {
    const response = await fetch('http://localhost:8080/loginServlet',
        {
            mode: 'no-cors'
        }
    );
    console.log(response.json())
}