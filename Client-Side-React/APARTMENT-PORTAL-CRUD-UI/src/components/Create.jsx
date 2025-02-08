import React, { useState } from "react";
import axios from "axios";
import {
  Typography,
  TextField,
  Button,
  Paper,
  Box,
} from "@mui/material";
import { useNavigate } from "react-router-dom";
const initial = { id:"",name: "", areaLocated: "", noOfFlatsAvailable: 0,noOfFlatsSold: 0, ratePerFlat: 0};


const Create = () => {
  const navigate = useNavigate();
  const [apartment, setApartment] = useState(initial);

  const handleSubmit = (e) => {
    console.log("Apartment post : "+apartment);
    e.preventDefault();
    axios
      .post("http://localhost:8080/apartment",apartment)
      .then((resp) => {
        console.log(resp.data);
        navigate("/");  // Navigate only after success
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const { id, name, areaLocated, noOfFlatsAvailable, noOfFlatsSold, ratePerFlat } = apartment;

  return (
    <Paper sx={{ padding:"1%"}} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
        Create New Apartment
      </Typography>
      <form autoComplete="off" noValidate onSubmit={handleSubmit}>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
           <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            onChange={(e) => setApartment({ ...apartment, id: e.target.value })}
            label="Enter your Apartment ID"
            variant="outlined"
            value={apartment.id}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setApartment({ ...apartment, name: e.target.value })}
            label="Apartment name"
            variant="outlined"
            value={apartment.name}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setApartment({ ...apartment, areaLocated: e.target.value })}
            label="Apartment Located At"
            variant="outlined"
            value={apartment.areaLocated}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) =>
              setApartment({ ...apartment, noOfFlatsAvailable: e.target.value })
            }
            label="No of flats available"
            variant="outlined"
            value={apartment.noOfFlatsAvailable}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) =>
              setApartment({ ...apartment, noOfFlatsSold: e.target.value })
            }
            label="No of Flats Sold"
            variant="outlined"
            value={apartment.noOfFlatsSold}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) =>
              setApartment({ ...apartment, ratePerFlat: e.target.value })
            }
            label="Rate Per Flat"
            variant="outlined"
            value={apartment.ratePerFlat}
          />
          
          <Button
            sx={{ width: "50%", margin: "2% auto" }}
            variant="contained"
            type="submit"
          >
            Submit
          </Button>
        </Box>
      </form>
    </Paper>
  );
}

export default Create