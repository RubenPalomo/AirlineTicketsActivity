import axios from "axios";

function DBConnector(URL) {
  axios
    .get(URL)
    .then((response) => {
      console.log(response);
      return response;
    })
    .catch((e) => {
      return e;
    });
}

export default DBConnector;
