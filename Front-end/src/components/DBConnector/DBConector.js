import axios from "axios";

function DBConnector(URL) {
  axios
    .get(URL)
    .then((response) => {
      if (response == null) return;
    })
    .catch((e) => {
      return e;
    });
}

export default DBConnector;
