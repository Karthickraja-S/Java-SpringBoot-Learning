import React from 'react'
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import {
    Card,
    Grid,
    Typography,
  } from "@mui/material";
  import axios from "axios";
  import { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';

const Search = () => {
    const [apartment, setapartment] = useState(null);
    const navigate = useNavigate();

const handleEdit = (id) => {
  navigate("/edit",{state:{id}});
}

    useEffect(() => {
        const fetchInitialapartments = async () => {
            const response = await axios.get(`http://localhost:8080/apartments`);
            setapartment(response.data);
        }
         fetchInitialapartments();
      }, []);

      const handleDelete = (id) => {
        async function deleteApartment() {
          await axios.delete(`http://localhost:8080/apartment/${id}`);
          console.log("Delete Method Triggered.")
      }
      deleteApartment();
      window.location.reload();
      }

  return (
    <>
      <Grid container spacing={2} sx={{ margin: "1%" }}>
      <Grid item xs={12} sx={12} md={12} lg={12}>
      </Grid>
      {apartment &&
        apartment.map((p) => {
          return (
            <Grid key={p.id} item xs={12} md={2} lg={4}>
              <Card sx={{ padding: "1%", overflow: "hidden", width: "85%", backgroundColor:"#ADD8E6" }}>
                <Typography        
                  variant="h5"
                  sx={{ fontSize: "2rem", fontWeight: "500", fontFamily:"sans-serif" }}
                >
             {p.name}
                </Typography>
                <Typography  sx={{ color: "#585858", marginTop:"2%", fontFamily:"cursive" }} variant="body" >
                  Area Located : {p.areaLocated}
                </Typography>
                <br />
                <Typography variant="h6" sx={{ fontFamily:"unset", fontSize:"200"}}>
                No Of Flats Avaiable : {p.noOfFlatsAvailable}
                </Typography>
                <br />
                <Typography variant="h6" sx={{ fontFamily:"unset", fontSize:"200"}}>
                No Of Flats Sold : {p.noOfFlatsSold}
                </Typography>
                <br />
                <Typography variant="h6" sx={{ fontFamily:"unset", fontSize:"2  00"}}>
                Rate Per Flat : {p.ratePerFlat}
                </Typography>

               <DeleteIcon onClick={() => handleDelete(p.id)} />
                <EditIcon onClick={() => handleEdit(p.id)} />
              </Card>
            </Grid>
          );
        })}
    </Grid>
    </>
 
  )
}

export default Search