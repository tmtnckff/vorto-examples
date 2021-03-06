import React, { Component } from 'react'
import Actions from '../../actions/'
import { withRouter } from 'react-router';



const PORT = process.env.REACT_APP_PORT || 8080
const { store } = require('../../store')


export class DeviceTooltip extends Component {

  popupClicked(device){
    try {
      store.dispatch(Actions.selectDevice(device))
    } catch (error) {
      console.log("error while selecting Device", error)
    }
    this.props.history.push('/device')

  }

 

  render() {
    let latitude = this.props.latitude
    let longitude =  this.props.longitude
    const thingImgSrc = this.props.device.imgSrc
    const imgSrc = thingImgSrc.startsWith('http') ? thingImgSrc : `http://${window.location.hostname}:${PORT}/${this.props.device.imgSrc}`

    return (
      <div onClick={() => {this.popupClicked(this.props.device)}} 
      className='tooltip-content'>
        <div className='tooltip-content__image'>
          <img alt='img of the device' src={imgSrc} height='100px' />
        </div>
        <div className='tooltip-content__title'>
          <h4>{this.props.device.attributes.thingName}</h4>
        </div>
        <div className="tooltip-content__info">
          <p><span className='attr-keyword'>Thing ID: </span>  <span>{this.props.device.thingId}</span></p>
          <p><span className='attr-keyword'>Location: </span>  <span>{latitude} lat, {longitude} long</span> </p>
        </div>
      </div >
    )
  }
}

export default withRouter(DeviceTooltip)
