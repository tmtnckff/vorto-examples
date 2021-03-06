import { Component, OnInit } from '@angular/core';
import { APIService, LoginState, PollingState } from 'src/app/service/api/api.service';
import { async } from '@angular/core/testing';

@Component({
  selector: 'app-mappings-view',
  templateUrl: './mappings-view.component.html',
  styleUrls: ['./mappings-view.component.scss']
})
export class MappingsViewComponent implements OnInit {

  constructor(private apiService: APIService) { }

  public mappingList = []
  public installedMappingList = []
  public discoveredMappingList = []

  public toggleIcon = "../../assets/icon/single-toggle.svg";
  public urlIcon = "../../assets/icon/url.svg";
  public vortoLogo = "../../assets/img/vorto-logo.png";
  public isLoggedIn

  public mappingPollingState

  public pollingStateTypes = PollingState

  ngOnInit() {

    this.apiService.loginState.subscribe(
      async res => {
        this.isLoggedIn = (res === LoginState.AUTHORIZED) ? true : false
      }, (err) => console.log(err)
    )


    this.apiService.mappingPollingState.subscribe(
      async res => {
        this.mappingPollingState = res
      }, (err) => console.log(err)
    )


    this.apiService.installedMappingsList.subscribe(
      async res => {
        console.log("Refreshing list of installed Mappings: ", res)
        this.addToMappingList(res, this.installedMappingList)
        this.combineMappingLists()
      }, (err) => console.log(err)
    )

    this.apiService.discoveredMappingsList.subscribe(
      async res => {
        this.addToMappingList(res, this.discoveredMappingList)
        this.combineMappingLists()
        console.log("Refreshing list of other discovered Mappings: ", res)
      }, (err) => console.log(err)
    )
  }



  addToMappingList(mappingListToAdd, targetMappingList) {


    mappingListToAdd.map(element => {

      const modelId = (element.modelId && element.modelId.prettyFormat) ? element.modelId.prettyFormat : "No id provided"

      const mapping = {
        modelId: modelId,
        displayName: (element.modelId && element.modelId.name) ? element.modelId.name : "No name provided",
        namespace: (element.modelId && element.modelId.namespace) ? element.modelId.namespace : "No namespace provided",
        description: (element.description) ? element.description : "No description provided",
        version: (element.modelId && element.modelId.version) ? element.modelId.version : "No version provided",
        isInstalled: (element.installed) ? element.installed : false,
        unresolved: element.unresolved,
        url: this.getRepositoryUrl(modelId)
      }
      targetMappingList.push(mapping)
    })
  }

  combineMappingLists() {



    this.installedMappingList.map(mapping => {
      if (!this.isMappingIn(mapping)) {
        this.mappingList.push(mapping)
      } 
    })



    this.discoveredMappingList.map(mapping => {

      if (!this.isMappingIn(mapping) && !this.isMappingInstalled(mapping)) {
        this.mappingList.push(mapping)
      }

      //updated if unresolved state has changed
      if (this.hasUnresolvedStateChanged(mapping)) {
        this.updateMappingInList(mapping)
      }


    })

  }

  updateMappingInList(mapping2update) {
    this.mappingList.forEach((mapping, index) => {
      if (mapping.modelId === mapping2update.modelId) {
        this.mappingList[index] = mapping2update
      }
    })
  }

  isMappingInstalled(mapping){
    return this.installedMappingList.some(x =>
      x.modelId === mapping.modelId &&
      x.description === mapping.description)
  }

  isMappingIn(mapping) {
    return this.mappingList.some(x =>
      x.modelId === mapping.modelId &&
      x.description === mapping.description)
  }
  hasUnresolvedStateChanged(mapping) {
    return this.mappingList.some(x =>
      x.modelId === mapping.modelId &&
      x.unresolved !== mapping.unresolved)
  }


  removeFromMappingList(id) {
    this.mappingList.forEach((mapping, index) => {
      if (mapping.modelId === id) this.mappingList.splice(index, 1);
    });
  }


  installMapping(modelId) {
    this.apiService.updateMappingInstallState(modelId, true)
    this.removeFromMappingList(modelId)
  }

  uninstallMapping(modelId) {
    this.apiService.updateMappingInstallState(modelId, false)
    this.removeFromMappingList(modelId)
  }

  getRepositoryUrl(id) {
    return "https://vorto.eclipse.org/#/details/" + id
  }
}
